package com.triptrop.adapter.adapter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.triptrop.adapter.dto.HotelDto;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Component
public class HotelApiAdapterImpl implements HotelApiAdapter {


    //Dit is de fetchHotelDetail voor BOOKING.COM
    public HotelDto fetchHotelDetail(int hotelId,String arrivalDate, String departureDate){
        final int HOTELID = hotelId;
        final String ARRIVALDATE = arrivalDate;
        final String DEPARTUREDATE = departureDate;
        String uri = "https://booking-com15.p.rapidapi.com/api/v1/hotels/getHotelDetails?hotel_id="+HOTELID+"&arrival_date="+ARRIVALDATE+"&departure_date="+DEPARTUREDATE+"&adults=1&children_age=1%2C17&room_qty=1&units=metric&temperature_unit=c&languagecode=en-us&currency_code=EUR";


        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .header("x-rapidapi-key", "fe78ddf025mshec614b485c4c5fbp12989fjsne86a995cf15f")
                    .header("x-rapidapi-host", "booking-com15.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Parse JSON response
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(response.body());

            // Extract hotel name (adjust path based on API response)
            String hotelName = rootNode.path("data").path("hotel_name").asText();
            String hotelLocation = rootNode.path("data").path("address").asText();

            // Populate HotelDto
            HotelDto hotel = new HotelDto();
            hotel.setHotelName(hotelName);
            hotel.setLocatie(hotelLocation);

            return hotel;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();  // Print detailed error message
        }

        return new HotelDto();
    }

    //Dit is de fetchHotelDetail voor TRIPADVISOR
//    public HotelDto fetchHotelDetail(int hotelId,String arrivalDate, String departureDate){
//        final int HOTELID = hotelId;
//        final String ARRIVALDATE = arrivalDate;
//        final String DEPARTUREDATE = departureDate;
//        String uri = "https://tripadvisor16.p.rapidapi.com/api/v1/hotels/getHotelDetails?id="+HOTELID+"&checkIn="+ARRIVALDATE+"&checkOut="+DEPARTUREDATE+"&currency=USD";
//
//        try {
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(URI.create(uri))
//                    .header("x-rapidapi-key", "fe78ddf025mshec614b485c4c5fbp12989fjsne86a995cf15f")
//                    .header("x-rapidapi-host", "tripadvisor16.p.rapidapi.com")
//                    .method("GET", HttpRequest.BodyPublishers.noBody())
//                    .build();
//            HttpClient client = HttpClient.newHttpClient();
//            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//            // Parse JSON response
//            ObjectMapper objectMapper = new ObjectMapper();
//            JsonNode rootNode = objectMapper.readTree(response.body());
//
//            // Extract Details
//            String hotelName = rootNode.path("data").path("title").asText();
//            String hotelLocation = rootNode.path("data").path("location").path("address").asText();
//
//            HotelDto hotel = new HotelDto();
//            hotel.setHotelName(hotelName);
//            hotel.setLocatie(hotelLocation);
//
//            return hotel;
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();  // Print detailed error message
//        }
//
//        return new HotelDto();
//    }
}

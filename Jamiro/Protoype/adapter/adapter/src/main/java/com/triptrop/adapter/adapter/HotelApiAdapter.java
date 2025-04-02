package com.triptrop.adapter.adapter;

import com.triptrop.adapter.dto.HotelDto;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
@Component
public class HotelApiAdapter {
    public HotelDto fetchHotelDetail(int hotelId){
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://booking-com15.p.rapidapi.com/api/v1/hotels/getHotelDetails?hotel_id=191605&arrival_date=2025-04-11&departure_date=2025-04-14&adults=1&children_age=1%2C17&room_qty=1&units=metric&temperature_unit=c&languagecode=en-us&currency_code=EUR"))
                    .header("x-rapidapi-key", "fe78ddf025mshec614b485c4c5fbp12989fjsne86a995cf15f")
                    .header("x-rapidapi-host", "booking-com15.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();  // Print detailed error message
        }


        HotelDto hotel = new HotelDto();
        return hotel;
    }

}

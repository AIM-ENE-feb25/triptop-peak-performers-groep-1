const requestOptions = {
  method: "GET",
  redirect: "follow"
};



// HotelId for Booking.com
const HotelId = 191605;

// HotelId for Tripadvisor
// const HotelId = 230901;


const ArrivalDate = "2025-04-11";
const DepartureDate = "2025-04-18";
const url = "http://localhost:8080/getHotelDetails?hotelId=" + HotelId + "&arrivalDate=" + ArrivalDate + "&departureDate=" + DepartureDate;

fetch(url, requestOptions)
  .then((response) => response.text())
  .then((result) => console.log(result))
  .catch((error) => console.error(error));
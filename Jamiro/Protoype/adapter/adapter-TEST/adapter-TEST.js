const requestOptions = {
  method: "GET",
  redirect: "follow"
};

fetch("http://localhost:8080/getHotelDetails?hotelId=191605&arrivalDate=2025-04-11&departureDate=2025-04-18", requestOptions)
  .then((response) => response.text())
  .then((result) => console.log(result))
  .catch((error) => console.error(error));
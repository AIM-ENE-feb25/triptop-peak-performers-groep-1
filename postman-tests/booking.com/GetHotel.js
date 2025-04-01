const myHeaders = new Headers();
myHeaders.append("x-rapidapi-host", "booking-com15.p.rapidapi.com");
myHeaders.append("x-rapidapi-key", "fe78ddf025mshec614b485c4c5fbp12989fjsne86a995cf15f");

const requestOptions = {
    method: "GET",
    headers: myHeaders,
    redirect: "follow"
};

fetch("https://booking-com15.p.rapidapi.com/api/v1/hotels/getHotelDetails?hotel_id=191605&arrival_date=2025-03-28&departure_date=2025-03-31&adults=1&children_age=1%2C17&room_qty=1&units=metric&temperature_unit=c&languagecode=en-us&currency_code=EUR", requestOptions)
    .then((response) => response.text())
    .then((result) => console.log(result))
    .catch((error) => console.error(error));
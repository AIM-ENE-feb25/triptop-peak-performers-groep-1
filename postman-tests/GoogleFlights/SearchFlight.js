const data = null;

const xhr = new XMLHttpRequest();
xhr.withCredentials = true;

xhr.addEventListener('readystatechange', function () {
    if (this.readyState === this.DONE) {
        console.log(this.responseText);
    }
});

xhr.open('GET', 'https://google-flights2.p.rapidapi.com/api/v1/searchFlights?departure_id=LAX&arrival_id=JFK&travel_class=ECONOMY&adults=1&show_hidden=1&currency=USD&language_code=en-US&country_code=US');
xhr.setRequestHeader('x-rapidapi-key', 'fe78ddf025mshec614b485c4c5fbp12989fjsne86a995cf15f');
xhr.setRequestHeader('x-rapidapi-host', 'google-flights2.p.rapidapi.com');

xhr.send(data);
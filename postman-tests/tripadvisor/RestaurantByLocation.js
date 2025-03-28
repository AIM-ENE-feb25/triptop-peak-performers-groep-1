const data = null;

const xhr = new XMLHttpRequest();
xhr.withCredentials = true;

xhr.addEventListener('readystatechange', function () {
    if (this.readyState === this.DONE) {
        console.log(this.responseText);
    }
});

xhr.open('GET', 'https://tripadvisor16.p.rapidapi.com/api/v1/restaurant/searchLocation?query=mumbai');
xhr.setRequestHeader('x-rapidapi-key', 'fe78ddf025mshec614b485c4c5fbp12989fjsne86a995cf15f');
xhr.setRequestHeader('x-rapidapi-host', 'tripadvisor16.p.rapidapi.com');

xhr.send(data);
const formdata = new FormData();
formdata.append("username", "edevries");
formdata.append("password", "3g2Rw9sT1x");

const requestOptions = {
    method: "POST",
    body: formdata,
    redirect: "follow"
};

fetch("http://localhost:8080/auth/login", requestOptions)
    .then((response) => response.text())
    .then((result) => console.log(result))
    .catch((error) => console.error(error));
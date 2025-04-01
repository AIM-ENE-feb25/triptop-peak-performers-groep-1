package com.example.prototype.Prototype_Taha.Service;

import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class TokenService {
    private HttpClient client = HttpClient.newHttpClient();
    private static final String CHECK_ACCESS_URL = "http://identity-wiremock.minordevops.nl:8080/checkAppAccess?token=";

    public String checkAppAccess(String token, String username, String application) {
        String url = CHECK_ACCESS_URL + token;
        String requestBody = "{\"username\": \"" + username + "\", \"application\": \"" + application + "\"}";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

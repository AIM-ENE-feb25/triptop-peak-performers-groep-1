package com.example.prototype.Prototype_Taha.Service;

import com.example.prototype.Prototype_Taha.Domain.AuthRequest;
import org.springframework.stereotype.Service;

import org.springframework.stereotype.Service;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class UserService {
    private HttpClient client = HttpClient.newHttpClient();
    private static final String LOGIN_URL = "http://identity-wiremock.minordevops.nl:8080/login";

    public String login(String username, String password) {
        AuthRequest requestPayload = new AuthRequest(username, password);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(LOGIN_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestPayload.toJson()))
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

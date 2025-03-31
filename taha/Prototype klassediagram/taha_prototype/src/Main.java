import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

class AuthRequest {
    private String username;
    private String password;

    public AuthRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String toJson() {
        return "{\"username\": \"" + username + "\", \"password\": \"" + password + "\"}";
    }
}

class UserService {
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

class TokenService {
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

class LoggerService {
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}

class AuthFacade {
    private UserService userService = new UserService();
    private TokenService tokenService = new TokenService();
    private LoggerService loggerService = new LoggerService();

    public String login(String username, String password) {
        loggerService.log("Attempting login for user: " + username);
        String token = userService.login(username, password);
        if (token != null) {
            loggerService.log("Login successful for user: " + username);
        } else {
            loggerService.log("Login failed for user: " + username);
        }
        return token;
    }

    public String checkAppAccess(String token, String username, String application) {
        loggerService.log("Checking app access for user: " + username);
        return tokenService.checkAppAccess(token, username, application);
    }
}

class AuthController {
    private AuthFacade authFacade = new AuthFacade();

    public String login(String username, String password) {
        return authFacade.login(username, password);
    }

    public String checkAppAccess(String token, String username, String application) {
        return authFacade.checkAppAccess(token, username, application);
    }
}

public class Main {
    public static void main(String[] args) {
        AuthController authController = new AuthController();

        // Login
        String loginResponse = authController.login("edevries", "3g2Rw9sT1x");
        System.out.println("Login Response: " + loginResponse);

        String token = loginResponse.split("\"token\":\"")[1].split("\"")[0];
        System.out.println("Extracted Token: " + token);

        // Check App Access
        String accessResponse = authController.checkAppAccess(token, "edevries", "triptop");
        System.out.println("Access Response: " + accessResponse);
    }
}

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class WireMockLoginTest {
    public static void main(String[] args) {
        try {
            String username = "edevries";
            String password = "3g2Rw9sT1x";

            String loginResponse = sendPostRequest("https://triptop-identity.wiremockapi.cloud/login",
                    new JSONObject().put("username", username).put("password", password).toString());

            JSONObject loginJson = new JSONObject(loginResponse);
            String token = loginJson.getString("token");

            System.out.println("Token ontvangen: " + token);

            String checkAccessResponse = sendPostRequest("https://triptop-identity.wiremockapi.cloud/checkAppAccess?token=" + token,,
                    new JSONObject().put("username", username).put("application", "triptop").toString());

            System.out.println("Applicatie toegang: " + checkAccessResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String sendPostRequest(String urlString, String jsonInputString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        StringBuilder response = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
        }
        return response.toString();
    }
}
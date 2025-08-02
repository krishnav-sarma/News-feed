import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.charset.StandardCharsets;

public class SimpleNewsFeed {
    private static final String API_KEY = "pub_d7beb27dbab1438d88b188dabfdd025a"; 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select a news category by number:");
        System.out.println("1. Technology");
        System.out.println("2. Sports");
        System.out.println("3. Business");
        System.out.println("4. World");
        System.out.println("5. Entertainment");
        System.out.println("6. Environment");
        System.out.println("7. Food");
        System.out.println("8. Health");
        System.out.println("9. Politics");
        System.out.println("10. Science");
        System.out.println("11. Tourism");
        System.out.println("12. Top (default)");

        System.out.print("Enter choice (1-12): ");
        int choice = scanner.nextInt();
        scanner.close();

        String category;

        switch (choice) {
            case 1: category = "technology"; break;
            case 2: category = "sports"; break;
            case 3: category = "business"; break;
            case 4: category = "world"; break;
            case 5: category = "entertainment"; break;
            case 6: category = "environment"; break;
            case 7: category = "food"; break;
            case 8: category = "health"; break;
            case 9: category = "politics"; break;
            case 10: category = "science"; break;
            case 11: category = "tourism"; break;
            case 12:
            default:
                category = "top";
                System.out.println("Invalid or default choice selected. Showing top news.");
        }

        try {
            String endpoint = "https://newsdata.io/api/1/news?country=in&category=" + category + "&apikey=" + API_KEY;

            URL url = new URL(endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            

            int status = conn.getResponseCode();
            System.out.println("\nHTTP Response Code: " + status);

            BufferedReader in = new BufferedReader(new InputStreamReader(
                (status >= 200 && status < 300) ? conn.getInputStream() : conn.getErrorStream(), StandardCharsets.UTF_8));

            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject jsonResponse = new JSONObject(response.toString());

            if (!jsonResponse.optString("status", "").equals("success")) {
                System.out.println("API Error: " + jsonResponse.optString("msg", "Unknown error"));
                return;
            }

            JSONArray articles = jsonResponse.getJSONArray("results");

            System.out.println("\n==================== TOP " + category.toUpperCase() + " NEWS ====================\n");

            for (int i = 0; i < Math.min(10, articles.length()); i++) {
                JSONObject article = articles.getJSONObject(i);
                String title = article.optString("title", "No Title");
                String desc = article.optString("description", "No Description");
                String urlLink = article.optString("link", "No URL");

                System.out.println("<==>  Title       : " + title);
                System.out.println(">>>  Description : " + (desc.length() > 200 ? desc.substring(0, 200) + "..." : desc));
                System.out.println(">>>  Link        : " + urlLink);
                System.out.println("--------------------------------------------------\n");
            }

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

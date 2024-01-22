import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;


import org.json.JSONArray;
import org.json.JSONObject;


public class PokeAPI {
    public static void getNowPlaying() {
        String url = "https://pokeapi.co/api/v2/pokemon/?limit=1400";
        String urlResponse = "";
        try {
            URI myUri = URI.create(url); // creates a URI object from the url string
            HttpRequest request = HttpRequest.newBuilder().uri(myUri).build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            urlResponse = response.body();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(urlResponse);
        // when determining HOW to parse the returned JSON data,
        // first, print out the urlResponse, then copy/paste the output
        // into the online JSON parser: https://jsonformatter.org/json-parser
        // use the visual model to help you determine how to parse the data!
        JSONObject jsonObj = new JSONObject(urlResponse);
        JSONArray pokeList = jsonObj.getJSONArray("results");
        for (int i = 0; i < pokeList.length(); i++) {
            JSONObject pokeObj = pokeList.getJSONObject(i);
            String pokeName = pokeObj.getString("name");
            String pokeURL = pokeObj.getString("url");
            System.out.println(pokeName + " " + pokeURL);
        }
/*
       Scanner scan = new Scanner(System.in);
       System.out.print("\nEnter a movie ID to learn more: ");
       String selectedID = scan.nextLine();
       String endpoint2 = "https://api.themoviedb.org/3/movie/" + selectedID;
       String url2 = endpoint2 + queryParameters;
       String urlResponse2 = "";
       try {
           URI myUri = URI.create(url2); // creates a URI object from the url string
           HttpRequest request = HttpRequest.newBuilder().uri(myUri).build();
           HttpClient client = HttpClient.newHttpClient();
           HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
           urlResponse2 = response.body();
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }


       JSONObject jsonObj2 = new JSONObject(urlResponse2);
       String title = jsonObj2.getString("title");
       String page = jsonObj2.getString("homepage");
       String overview = jsonObj2.getString("overview");
       String release = jsonObj2.getString("release_date");
       int runtime = jsonObj2.getInt("runtime");
       int revenue = jsonObj2.getInt("revenue");
       System.out.println("\nTitle: " + title);
       System.out.println("Homepage: " + page);
       System.out.println("Overview: " + overview);
       System.out.println("Released on: " + release);
       System.out.println("Runtime: " + runtime + " minutes");
       System.out.println("Revenue: $" + revenue);


       System.out.println("Genres:");
       JSONArray genres = jsonObj2.getJSONArray("genres");
       for (int i = 0; i < genres.length(); i++) {
           JSONObject obj = genres.getJSONObject(i);
           String genre = obj.getString("name");
           System.out.println(genre);
       }


*/
    }

    public static void getSpecific(int pokeID){
        GetDetail yoink = new GetDetail();

        String url2 = "https://pokeapi.co/api/v2/pokemon/" + pokeID;
        String urlResponse2 = "";
        try {
            URI myUri = URI.create(url2); // creates a URI object from the url string
            HttpRequest request = HttpRequest.newBuilder().uri(myUri).build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            urlResponse2 = response.body();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        JSONObject jsonObj2 = new JSONObject(urlResponse2);
        int weight =  jsonObj2.getInt("weight");
        int height = jsonObj2.getInt("height");
        String name = jsonObj2.getString("name");
        System.out.println("Name: " +  name);
        System.out.println("Weight: " + weight/10.0 + " kg");
        System.out.println("Height: " + height/10.0 + " m");
    }

}

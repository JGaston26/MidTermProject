import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetDetail {

    public static int getPokemonIntDetails(String pokemonUrl, String detail) {
        try {
            URI pokemonUri = URI.create(pokemonUrl);
            HttpRequest pokemonRequest = HttpRequest.newBuilder().uri(pokemonUri).build();
            HttpClient pokemonClient = HttpClient.newHttpClient();
            HttpResponse<String> pokemonResponse = pokemonClient.send(pokemonRequest, HttpResponse.BodyHandlers.ofString());
            String pokemonDetailsResponse = pokemonResponse.body();

            JSONObject pokemonDetailsObj = new JSONObject(pokemonDetailsResponse);
            return pokemonDetailsObj.getInt(detail);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
    public static String getPokemonStringDetails(String pokemonUrl, String detail) {
        try {
            URI pokemonUri = URI.create(pokemonUrl);
            HttpRequest pokemonRequest = HttpRequest.newBuilder().uri(pokemonUri).build();
            HttpClient pokemonClient = HttpClient.newHttpClient();
            HttpResponse<String> pokemonResponse = pokemonClient.send(pokemonRequest, HttpResponse.BodyHandlers.ofString());
            String pokemonDetailsResponse = pokemonResponse.body();

            JSONObject pokemonDetailsObj = new JSONObject(pokemonDetailsResponse);
            return pokemonDetailsObj.getString(detail);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "error";
        }
    }
}


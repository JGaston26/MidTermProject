import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;


import org.json.JSONArray;
import org.json.JSONObject;

public class GetDexEntries {

    public static void DexEntries(int pokeID) {
        String url = "https://pokeapi.co/api/v2/pokemon-species/" + pokeID;
        String urlResponse = "";
         try{
             URI myURI = URI.create(url);
             HttpRequest request = HttpRequest.newBuilder().uri(myURI).build();
             HttpClient client = HttpClient.newHttpClient();
             HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
             urlResponse = response.body();
         }catch (Exception e){
             System.out.println(e.getMessage());
         }
         JSONObject dexObj = new JSONObject(urlResponse);
        JSONArray dexEntries = dexObj.getJSONArray("flavor_text_entries");
        for (int i = 0; i < dexEntries.length(); i++) {
            JSONObject entry = dexEntries.getJSONObject(i);
            if (entry.getJSONObject("language").getString("name").equals("en")) {
                String flavorText = entry.getString("flavor_text");
                System.out.println("Dex Entry: " + flavorText);
                break;
            }
        }
    }
    public static void getType(int pokeID){
        String url = "https://pokeapi.co/api/v2/pokemon/" + pokeID;
        String urlResponse = "";
        try{
            URI myURI = URI.create(url);
            HttpRequest request = HttpRequest.newBuilder().uri(myURI).build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
            urlResponse = response.body();
        }catch (Exception e){
            System.out.println(e.getMessage());
        } JSONObject typeObj = new JSONObject(urlResponse);
        JSONArray types = typeObj.getJSONArray("types");
        for(int i = 0; i < types.length(); i++){
            JSONObject typeObject = types.getJSONObject(i);

            int typeSlot = typeObject.getInt("slot");
            JSONObject typeInfo = typeObject.getJSONObject("type");
            String typeName = typeInfo.getString("name");
            String typeURL = typeInfo.getString("url");

            System.out.print("Type: " + typeName + "\n");
            //System.out.println("Type URL: " + typeURL);
        }
    }

}

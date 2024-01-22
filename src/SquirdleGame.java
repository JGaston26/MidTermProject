import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;


import org.json.JSONArray;
import org.json.JSONObject;


public class SquirdleGame {

    public static void pokeInfoGame(){
        boolean end = false;
        while(!end){
            Scanner scan = new Scanner(System.in);
            System.out.println("Welcome to the PokeInfoGame!");
            System.out.print("Enter in a Pokemon Dex Number to learn some info about that pokemon! ");
            int dexNum = scan.nextInt();
            scan.nextLine();
            String url = "https://pokeapi.co/api/v2/pokemon/" + dexNum;
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
            System.out.println(" ");
            PokeAPI.getSpecific(dexNum);
            System.out.println(" ");
            GetDexEntries.getType(dexNum);
            System.out.println(" ");
            GetDexEntries.DexEntries(dexNum);
            System.out.println(" ");
            System.out.print("Would you like to get the information of another pokemon? (y/n) ");
            String ask = scan.nextLine();
            if(ask.equals("y")){
                pokeInfoGame();
            }else{
                end = true;
                System.out.println("Thanks for playing!");
            }
        }

    }

}

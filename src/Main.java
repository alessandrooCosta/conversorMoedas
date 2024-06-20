import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Digite o valor que será convertido: ");
        Scanner scan = new Scanner(System.in);
        String valor = scan.nextLine();
        System.out.println("Digite o código da moeda: ");
        String moedaBase = scan.nextLine();
        System.out.println("Agora informe para qual moeda este valor precisa ser convertido:");
        String moedaConvertida =scan.nextLine();
        System.out.println("");
        String linkApi = "https://v6.exchangerate-api.com/v6/183f02f3f6692bccf61e29fd/pair/"+moedaBase+"/"+moedaConvertida+"/"+valor;
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(linkApi)).build();
        HttpResponse<String> response = cliente.send(request ,HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        Gson gson = new Gson();
        Moeda moedaRecord = gson.fromJson(json, Moeda.class);
        Moedas moedas = new Moedas(moedaRecord);
        System.out.println(moedaRecord);
        System.out.println(moedas);
    }
}
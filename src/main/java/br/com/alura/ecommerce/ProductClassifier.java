package br.com.alura.ecommerce;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

public class ProductClassifier {
    static void main() {

        var key = System.getenv("GOOGLE_API_KEY");

        Client client = Client.builder().apiKey(key).build();
        var user = "Escova de dentes";
        var system = "Você é um categorizador de produtos";


        for (int i = 1; i <= 5; i++) {
            IO.println("- - - Resposta " + i + " - - -");


            String fullPrompt = system + "\n\nUsuário: " + user;
            GenerateContentResponse response = client.models.generateContent(
                    "gemini-3.5-flash-lite",
                    fullPrompt,
                    null
            );

            IO.println(response.text());

            if (i < 5) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }
}


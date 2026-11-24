package br.com.alura.ecommerce;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

public class TestaIntegracao {
    static void main() {

        var key = System.getenv("GOOGLE_API_KEY");

        Client client = Client.builder().apiKey(key).build();
        var user = "Gere 5 produtos";
        var system = "Você é um gerador de produtos fictícios para um ecommerce e deve gerar apenas o nome dos produtos solicitados pelo usuário";



        String fullPrompt = system + "\n\nUsuário: " + user;
        GenerateContentResponse response = client.models.generateContent(
                "gemini-3.5-flash-lite",
                fullPrompt,
                null
        );

        IO.println(response.text());

    }
}

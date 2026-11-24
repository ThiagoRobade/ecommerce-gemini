package br.com.alura.ecommerce;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

public class TestaIntegracao {
    static void main() {

        var user = "Gere 5 produtos";
        var system = "Você é um gerador de produtos fictícios para um ecommerce e deve gerar apenas o nome dos produtos solicitados pelo usuário";

        Client client = new Client();

        String fullPrompt = system + "\n\nUsuário: " + user;
        GenerateContentResponse response = client.models.generateContent(
                "gemini-3.5-flash-lite",
                fullPrompt,
                null
        );

        IO.println(response.text());

    }
}

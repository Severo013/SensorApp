package br.unesp.rc.modelo;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class Assistente {

    /*
     * Classe que representa o assistente virtual.
     * Chave da API foi armazenada em uma variável de ambiente.
     */

    private static final String Token = System.getenv("API_KEY");
    private static final String Model = "gpt-3.5-turbo-0125";
    private final OpenAiService service;

    Assistente() {
         service = new OpenAiService(Token);
    }

    private String gerarResposta(String input) {
        CompletionRequest completionRequest = CompletionRequest.builder()
            .prompt(input)
            .model(Model)
            .echo(true)
            .build();

        return service.createCompletion(completionRequest).getChoices().getFirst().getText();
    }
}

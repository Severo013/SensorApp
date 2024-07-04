package br.unesp.rc.utils;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChatGPTUtil implements IChatGPTUtil {

    /*
     * Classe que representa o assistente virtual.
     * Chave da API foi armazenada em uma variável de ambiente.
     */

    private static final String Token = API_KEY;
    private static final String Model = "gpt-3.5-turbo-0125";
    private final OpenAiService service;

    public ChatGPTUtil() {
        service = new OpenAiService(Token);
    }

    public String gerarResposta(String input) {

        input = "Imagine que você é um assistente virtual da administração de uma cidade inteligente, dê uma resposta breve, " + input;

        final List<ChatMessage> messages = new ArrayList<>();
        final ChatMessage systemMessage = new ChatMessage(ChatMessageRole.SYSTEM.value(), input);
        messages.add(systemMessage);

        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest
                .builder()
                .model(Model)
                .messages(messages)
                .n(1)
                .maxTokens(500)
                .logitBias(new HashMap<>())
                .build();

        return service.createChatCompletion(chatCompletionRequest)
                .getChoices()
                .getFirst()
                .getMessage()
                .getContent();
    }
}

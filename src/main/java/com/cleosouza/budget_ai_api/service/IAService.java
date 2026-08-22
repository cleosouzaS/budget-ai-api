package com.cleosouza.budget_ai_api.service;

import com.cleosouza.budget_ai_api.tool.TransacaoTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class IAService {

    private final ChatClient chatClient;
    private final TransacaoTools transacaoTools;

    public IAService(
            ChatClient.Builder chatClientBuilder,
            TransacaoTools transacaoTools) {

        this.chatClient = chatClientBuilder.build();
        this.transacaoTools = transacaoTools;
    }

    public String perguntar(String pergunta) {
        return chatClient
                .prompt()
                .user(pergunta)
                .tools(transacaoTools)
                .call()
                .content();
    }
}

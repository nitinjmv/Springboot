package com.jmv.ollama.sb_ai_test.controller;


import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


import org.springframework.ai.ollama.OllamaChatClient;

import java.util.Map;

@RestController
@RequestMapping("ai")
public class ChatController {

    private final OllamaChatClient chatClient;

    @Autowired
    public ChatController(OllamaChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("generate")
    public Map generate(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        return Map.of("generation", chatClient.call(message));
    }

    @GetMapping("generateStream")
    public Flux<ChatResponse> generateStream(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        Prompt prompt = new Prompt(new UserMessage(message));
        return chatClient.stream(prompt);
    }

    @GetMapping("chat")
    public Flux<ChatResponse> promptResponse(
            @RequestParam("message") String prompt
    ) {
        Prompt promptOb = new Prompt(prompt);
        Flux<ChatResponse> response = chatClient.stream(promptOb);
        return response;
    }
}
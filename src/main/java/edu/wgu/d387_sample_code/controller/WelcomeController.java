package edu.wgu.d387_sample_code.controller;

import edu.wgu.d387_sample_code.service.WelcomeMessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/welcome")
public class WelcomeController {

    private final WelcomeMessageService welcomeMessageService;

    public WelcomeController(WelcomeMessageService welcomeMessageService) {
        this.welcomeMessageService = welcomeMessageService;
    }

    @GetMapping
    public CompletableFuture<List<String>> getWelcomeMessages() {
        CompletableFuture<String> englishMessage = welcomeMessageService.getEnglishWelcomeMessage();
        CompletableFuture<String> frenchMessage = welcomeMessageService.getFrenchWelcomeMessage();

        return CompletableFuture.allOf(englishMessage, frenchMessage)
                .thenApply(v -> {
                    List<String> messages = new ArrayList<>();
                    try {
                        messages.add(englishMessage.get());
                        messages.add(frenchMessage.get());
                    } catch (Exception e) {
                        throw new RuntimeException("Error getting welcome messages", e);
                    }
                    return messages;
                });
    }
} 
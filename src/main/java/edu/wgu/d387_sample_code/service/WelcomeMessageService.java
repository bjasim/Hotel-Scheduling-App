package edu.wgu.d387_sample_code.service;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.concurrent.CompletableFuture;

@Service
public class WelcomeMessageService {
    
    private final MessageSource messageSource;
    
    public WelcomeMessageService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    
    public CompletableFuture<String> getWelcomeMessage(Locale locale) {
        return CompletableFuture.supplyAsync(() -> {
            return messageSource.getMessage("welcome.message", null, locale);
        });
    }
    
    public CompletableFuture<String> getEnglishWelcomeMessage() {
        return getWelcomeMessage(Locale.ENGLISH);
    }
    
    public CompletableFuture<String> getFrenchWelcomeMessage() {
        return getWelcomeMessage(Locale.FRENCH);
    }
} 
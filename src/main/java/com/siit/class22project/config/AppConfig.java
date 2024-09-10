package com.siit.class22project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    private String language;
    private String currency;

    public AppConfig(String language, String currency) {
        this.language = language;
        this.currency = currency;
    }

    public String getLanguage() {
        return language;
    }

    public String getCurrency() {
        return currency;
    }

}

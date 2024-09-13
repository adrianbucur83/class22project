package com.siit.class22project.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${app.language:some default}")
    private String language;
    @Value("${app.currency}")
    private String currency;

    public String getLanguage() {
        return language;
    }

    public String getCurrency() {
        return currency;
    }

}

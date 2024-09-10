package com.siit.class22project.service.impl;

import com.siit.class22project.config.AppConfig;
import com.siit.class22project.service.PaymentProcessor;
import org.springframework.stereotype.Service;

@Service
public class BankTransferService implements PaymentProcessor {

    public BankTransferService(AppConfig appConfig) {
        this.appConfig = appConfig;
    }
    private AppConfig appConfig;

    @Override
    public String process() {
        return "Bank transfer transaction successfull";
    }
}

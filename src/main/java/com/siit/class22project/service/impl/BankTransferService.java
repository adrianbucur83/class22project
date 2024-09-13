package com.siit.class22project.service.impl;

import com.siit.class22project.service.PaymentProcessor;
import org.springframework.stereotype.Service;

@Service("bankTransferService")
public class BankTransferService implements PaymentProcessor {

    @Override
    public String process() {
        return "Bank transfer transaction successfull";
    }
}

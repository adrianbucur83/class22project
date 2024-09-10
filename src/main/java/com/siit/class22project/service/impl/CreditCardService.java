package com.siit.class22project.service.impl;

import com.siit.class22project.service.PaymentProcessor;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService implements PaymentProcessor {
    @Override
    public String process() {
        return "Credit card transaction successfull";
    }
}

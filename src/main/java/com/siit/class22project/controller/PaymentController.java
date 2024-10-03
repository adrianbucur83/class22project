package com.siit.class22project.controller;

import com.siit.class22project.service.PaymentProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    PaymentProcessor paymentProcessor;
    PaymentProcessor creditCardService;

    @Autowired
    public PaymentController(@Qualifier("bankTransferService") PaymentProcessor bankTransferPaymentProcessor,
                             @Qualifier("creditCardService") PaymentProcessor creditCardService) {
        this.paymentProcessor = bankTransferPaymentProcessor;
        this.creditCardService = creditCardService;
    }


    @GetMapping("/payments/cards")
    public String processPayment() {
        return creditCardService.process();
    }

    @GetMapping("/payments/bankTransfer")
    public String processPaymentBankTransfer() {
        return paymentProcessor.process();
    }

}

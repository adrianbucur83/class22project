package com.siit.class22project.controller;

import com.siit.class22project.service.PaymentProcessor;
import com.siit.class22project.service.impl.BankTransferService;
import com.siit.class22project.service.impl.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class PaymentController {
    BankTransferService bankTransferService;
    CreditCardService creditCardService;

    @Autowired
    public PaymentController(BankTransferService bankTransferService, CreditCardService creditCardService) {
        this.bankTransferService = bankTransferService;
        this.creditCardService = creditCardService;
    }


    @GetMapping("/payments/cards")
    public String processPayment() {
        return creditCardService.process();
    }

    @GetMapping("/payments/bankTransfer")
    public String processPaymentBankTransfer() {
        return bankTransferService.process();
    }

}

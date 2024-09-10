package com.siit.class22project.controller;

import com.siit.class22project.config.AppConfig;
import com.siit.class22project.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

    private AppConfig appConfig;

    public MyController(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @GetMapping("/")
    public String index(@RequestParam String name) {
        return "Greetings from Spring Boot! Hi " + name +
                "\n App language " + appConfig.getLanguage() + "<br/> App currency " + appConfig.getCurrency();
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        Product product = new Product();
        product.setName("Table");
        product.setPrice(10.0);

        return List.of(product) ;
    }


}
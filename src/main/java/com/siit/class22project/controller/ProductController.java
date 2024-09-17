package com.siit.class22project.controller;

import com.siit.class22project.config.AppConfig;
import com.siit.class22project.model.Product;

import com.siit.class22project.model.ProductCreateDto;
import com.siit.class22project.model.ProductReturnDto;
import com.siit.class22project.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
@RequiredArgsConstructor
public class ProductController {

    private final AppConfig appConfig;
    private final ProductService productService;

    @GetMapping("/")
    public String index(@RequestParam String name) {
        return "Greetings from Spring Boot! Hi " + name +
                "<br/> App language " + appConfig.getLanguage() + "<br/> App currency " + appConfig.getCurrency();
    }

    @GetMapping("/products")
    public List<ProductReturnDto> getProducts() {
        Product product = new Product();
        product.setName("Table");
        product.setPrice(10.0);
        product.setProfit(1000);
        return List.of(product.toReturnDto()) ;
    }

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean createProduct(@RequestBody ProductCreateDto productCreateDto, @RequestParam boolean overwriteExistingProduct) {
        productService.createProduct(productCreateDto, overwriteExistingProduct);
        return true;
    }




}
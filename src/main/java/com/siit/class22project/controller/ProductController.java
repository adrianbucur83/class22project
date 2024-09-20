package com.siit.class22project.controller;

import com.siit.class22project.config.AppConfig;
import com.siit.class22project.model.Product;

import com.siit.class22project.model.ProductCreateDto;
import com.siit.class22project.model.ProductReturnDto;
import com.siit.class22project.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@Controller
//@ResponseBody pe fiecare metoda
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
        return List.of(product.toReturnDto());
    }

    @GetMapping("/products/{productId}")
    public ProductReturnDto getProducts(@PathVariable Long productId) {
        Product product = new Product();
        product.setId(1L);
        product.setName("Table");
        product.setPrice(10.0);
        product.setProfit(1000);
        Product product2 = new Product();
        product2.setId(2L);
        product2.setName("Chair");
        product2.setPrice(20.0);
        product2.setProfit(2);
        List<ProductReturnDto> productList = List.of(product.toReturnDto(), product2.toReturnDto());

        return productList.
                stream()
                .filter(productDto -> productDto.getId() == productId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Boolean> createProduct(@RequestBody ProductCreateDto productCreateDto, @RequestParam boolean overwriteExistingProduct) {
        productService.createProduct(productCreateDto, overwriteExistingProduct);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.CREATED);
    }


}
package com.siit.class22project.controller;

import com.siit.class22project.config.AppConfig;
import com.siit.class22project.model.ProductCreateDto;
import com.siit.class22project.model.ProductReturnDto;
import com.siit.class22project.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {

    private final AppConfig appConfig;
    private final ProductService productService;


    @GetMapping("/products")
    public List<ProductReturnDto> getProducts(Pageable pageable) {
        return productService.getProducts(pageable);
    }

    @GetMapping("/products/byName")
    public ProductReturnDto getProductByName(@RequestParam String name)
    {
        return productService.getProductByName(name);
    }

    @GetMapping("/products/{id}")
    public ProductReturnDto getProductByName2(@PathVariable Long id)
    {
        return productService.getProductById(id);
    }

    @PostMapping("/products")
    public ResponseEntity<ProductReturnDto> createProduct(@RequestBody @Valid ProductCreateDto productCreateDto) {
        ProductReturnDto productReturnDto = productService.createProduct(productCreateDto);
        return new ResponseEntity<>(productReturnDto, HttpStatus.CREATED);
    }


}
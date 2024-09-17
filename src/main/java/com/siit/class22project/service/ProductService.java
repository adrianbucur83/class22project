package com.siit.class22project.service;

import com.siit.class22project.model.ProductCreateDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Value("${minimum.profit}")
    private double minimumProfit;

    public void createProduct(ProductCreateDto productCreateDto, boolean overwriteExistingProduct) {
        if (overwriteExistingProduct) {
            System.out.println("Overriding existing products is allowed");
        }
        if (productCreateDto.getName().contains("Adi")) {
            throw new RuntimeException("Illegal product name");
        }
        if (productCreateDto.getProfit() < minimumProfit) {
            throw new RuntimeException("Invalid profit value " + productCreateDto.getProfit());
        }

        System.out.println("Product created: " + productCreateDto.getName());
    }
}

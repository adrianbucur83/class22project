package com.siit.class22project.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
public class ProductCreateDto {
    private String name;
    private double price;
    private double profit;


    public Product toProduct() {
        Product product = new Product();
        product.setName(this.getName());
        product.setPrice(this.getPrice());
        product.setProfit(this.getProfit());
        return product;
    }
}

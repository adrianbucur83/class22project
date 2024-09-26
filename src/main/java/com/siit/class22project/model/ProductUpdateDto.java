package com.siit.class22project.model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductUpdateDto {
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @Min(1)
    private double price;

    public Product toProduct() {
        Product product = new Product();
        product.setName(this.getName());
        product.setPrice(this.getPrice());
        return product;
    }
}

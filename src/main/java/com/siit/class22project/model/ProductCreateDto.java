package com.siit.class22project.model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductCreateDto {
    @NotNull
    @NotBlank
//    @Pattern(regexp = "[A-Z][a-z] [A-Z][a-z]")
    private String name;
    @Min(value = 6)
    @Digits(integer = 10, fraction = 2,  message = "Price must be in the format of 2 decimals, max 10 digits + 2 decimals")
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

package com.siit.class22project.model;

import lombok.Data;

@Data
public class Product {

    private String name;
    private double price;
    private double profit;

    public ProductReturnDto toReturnDto() {
        ProductReturnDto productReturnDto = new ProductReturnDto();
        productReturnDto.setName(name);
        productReturnDto.setPrice(price);
        return productReturnDto;
    }


}

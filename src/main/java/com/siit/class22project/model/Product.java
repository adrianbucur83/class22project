package com.siit.class22project.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "price")
    private double price;
    private double profit;


    public ProductReturnDto toReturnDto() {
        ProductReturnDto productReturnDto = new ProductReturnDto();
        productReturnDto.setName(name);
        productReturnDto.setPrice(price);
        productReturnDto.setId(this.id);
        return productReturnDto;
    }


}

package com.siit.class22project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean delivered;
    @OneToMany
    private List<Product> products;

    public OrderReturnDto toDto(Order order) {
        OrderReturnDto orderReturnDto = new OrderReturnDto();
        orderReturnDto.setId(order.getId());
        orderReturnDto.setDelivered(order.isDelivered());
        orderReturnDto.setProducts(order.getProducts()
                .stream()
                .map(Product::toReturnDto)
                .toList());
        return orderReturnDto;
    }

}

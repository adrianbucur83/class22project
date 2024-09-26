package com.siit.class22project.service;

import com.siit.class22project.model.Order;
import com.siit.class22project.model.OrderReturnDto;
import com.siit.class22project.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<OrderReturnDto> getOrders() {
        return orderRepository.findAll()
                .stream()
                .map(order -> order.toDto(order))
                .toList();
    }
}

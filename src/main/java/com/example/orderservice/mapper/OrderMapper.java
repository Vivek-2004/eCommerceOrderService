package com.example.orderservice.mapper;

import com.example.orderservice.dto.CreateOrderResponseDTO;
import com.example.orderservice.dto.OrderRequestDTO;
import com.example.orderservice.entity.Order;
import com.example.orderservice.enums.OrderStatus;

public class OrderMapper {
    public static Order toEntity(OrderRequestDTO dto) {
        Order order = Order.builder()
                .userId(dto.getUserId())
                .status(OrderStatus.PENDING)
                .build();
        return order;
    }

    public static CreateOrderResponseDTO toCrateOrderResponseDTO(Order order) {
        CreateOrderResponseDTO created = CreateOrderResponseDTO.builder()
                .orderId(order.getId())
                .orderStatus(order.getStatus())
                .build();
        return created;
    }
}
package com.example.orderservice.mapper;

import com.example.orderservice.dto.OrderItemDTO;
import com.example.orderservice.entity.Order;
import com.example.orderservice.entity.OrderItem;

public class OrderItemMapper {
    public static OrderItem orderItemRequestDTOtoOrderItemEntity(OrderItemDTO dto, Order order, double pricePerUnit, double totalPrice) {
        return OrderItem.builder()
                .order(order)
                .productId(dto.getProductId())
                .pricePerUnit(pricePerUnit)
                .quantity(dto.getQuantity())
                .totalPrice(totalPrice)
                .build();
    }
}
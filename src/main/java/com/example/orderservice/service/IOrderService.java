package com.example.orderservice.service;

import com.example.orderservice.dto.CreateOrderResponseDTO;
import com.example.orderservice.dto.OrderRequestDTO;

public interface IOrderService {
    CreateOrderResponseDTO createOrder(OrderRequestDTO request);
}
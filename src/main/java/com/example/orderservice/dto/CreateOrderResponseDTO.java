package com.example.orderservice.dto;

import com.example.orderservice.enums.OrderStatus;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderResponseDTO {
    private Long orderId;
    private OrderStatus orderStatus;
}
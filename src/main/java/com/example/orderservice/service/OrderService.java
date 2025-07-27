package com.example.orderservice.service;

import com.example.orderservice.clients.ProductServiceClient;
import com.example.orderservice.dto.CreateOrderResponseDTO;
import com.example.orderservice.dto.OrderItemDTO;
import com.example.orderservice.dto.OrderRequestDTO;
import com.example.orderservice.dto.ProductDTO;
import com.example.orderservice.entity.Order;
import com.example.orderservice.entity.OrderItem;
import com.example.orderservice.mapper.OrderItemMapper;
import com.example.orderservice.mapper.OrderMapper;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService {

    private final OrderRepository orderRepository;
    private final ProductServiceClient productServiceClient;

    public OrderService(OrderRepository _orderRepository, ProductServiceClient _productServiceClient) {
        this.orderRepository = _orderRepository;
        this.productServiceClient = _productServiceClient;
    }

    @Override
    public CreateOrderResponseDTO createOrder(OrderRequestDTO request) {
        Order entity = OrderMapper.toEntity(request);

        List<OrderItem> items = new ArrayList<>();

        for(OrderItemDTO item: request.getItems()) {
            // Fetch the product details for each item.
            ProductDTO product = productServiceClient.getProductById(item.getProductId());
            double pricePerUnit = product.getPrice();
            double totalPrice = pricePerUnit * item.getQuantity();
            OrderItem orderItem = OrderItemMapper.orderItemRequestDTOtoOrderItemEntity(
                    item,
                    entity,
                    pricePerUnit,
                    totalPrice
            );
            items.add(orderItem);
        }

        entity.setItems(items);
        Order savedOrder = orderRepository.save(entity);
        CreateOrderResponseDTO savedOrderDTO = OrderMapper.toCrateOrderResponseDTO(savedOrder);
        return savedOrderDTO;
    }
}
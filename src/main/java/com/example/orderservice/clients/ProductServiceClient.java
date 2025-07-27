package com.example.orderservice.clients;

import com.example.orderservice.dto.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductServiceClient {

    private final RestTemplate restTemplate;

    public ProductServiceClient(RestTemplate _restTemplate) {
        this.restTemplate = _restTemplate;
    }

    public ProductDTO getProductById(Long productId) {
        String url = "http://ECOMMERCESPRING/api/product/" + productId;

        ResponseEntity<ProductDTO> response = restTemplate.getForEntity(url, ProductDTO.class);

        return response.getBody();
    }
}
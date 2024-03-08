package com.example.orderservice.Service;

import com.example.orderservice.DTO.OrderDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

    ResponseEntity<?> addOrders(OrderDTO orderDTO);

    ResponseEntity<?> getAllOrders();

    ResponseEntity<?> getOrdersById(Integer id);

    ResponseEntity<?> deleteById(Integer id);

}

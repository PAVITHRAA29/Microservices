package com.example.orderservice.Controller;

import com.example.orderservice.DTO.OrderDTO;
import com.example.orderservice.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<?> addOrders(@RequestBody OrderDTO orderDTO){
        return orderService.addOrders(orderDTO);
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<?> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/getOrderById/{id}")
    public ResponseEntity<?> getOrdersById(@PathVariable("id")Integer id){
        return orderService.getOrdersById(id);
    }

    @DeleteMapping("/deleteOrderById/{id}")
    public ResponseEntity<?> deleteOrderById(@PathVariable("id")Integer id){
        return orderService.deleteById(id);
    }
}

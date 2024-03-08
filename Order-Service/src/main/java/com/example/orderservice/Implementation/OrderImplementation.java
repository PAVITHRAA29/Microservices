package com.example.orderservice.Implementation;

import com.example.orderservice.DTO.BookDTO;
import com.example.orderservice.DTO.OrderDTO;
import com.example.orderservice.Feign.BookFeign;
import com.example.orderservice.Model.Orders;
import com.example.orderservice.Repository.OrderRepo;
import com.example.orderservice.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderImplementation implements OrderService {

    private final OrderRepo orderRepo;

    private final BookFeign bookFeign;

    @Override
    public ResponseEntity<?> addOrders(OrderDTO orderDTO) {
        Orders orders = Orders.builder()
                .email(orderDTO.getEmail())
                .name(orderDTO.getName())
                .build();

        List<BookDTO> books = bookFeign.getBooksByIds(orderDTO.getBookIds());

        List<Integer> bookIdsFromBooks = books.stream()
                .map(BookDTO::getId)
                .collect(Collectors.toList());

        orders.setBookIds(bookIdsFromBooks);

        Orders order = orderRepo.save(orders);
        return ResponseEntity.ok(order);
    }

    @Override
    public ResponseEntity<?> getAllOrders() {
        List<Orders> ordersList = orderRepo.findAll(Sort.by("id").ascending());
        return ResponseEntity.ok(ordersList);
    }

    @Override
    public ResponseEntity<?> getOrdersById(Integer id) {
        Optional<Orders> bookEntityList = orderRepo.findById(id);
        return ResponseEntity.ok(bookEntityList);
    }


    @Override
    public ResponseEntity<?> deleteById(Integer id) {
        if (orderRepo.existsById(id)) {
            orderRepo.deleteById(id);
            return ResponseEntity.ok("Book Deleted");
        } else {
            return ResponseEntity.badRequest().body("Book not found");
        }
    }
}

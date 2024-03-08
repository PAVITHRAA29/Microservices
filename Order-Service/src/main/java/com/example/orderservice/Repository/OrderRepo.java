package com.example.orderservice.Repository;

import com.example.orderservice.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Integer> {
}

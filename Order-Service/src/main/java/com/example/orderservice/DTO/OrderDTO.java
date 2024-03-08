package com.example.orderservice.DTO;

import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderDTO {

    private Integer id;

    private String email;

    private String name;

    private List<Integer> bookIds;
}

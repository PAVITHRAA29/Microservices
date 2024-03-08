package com.example.bookservice.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BookDTO {

    private Integer id;
    private String Name;
    private String Author;
}

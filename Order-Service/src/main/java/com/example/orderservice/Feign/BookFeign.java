package com.example.orderservice.Feign;

import com.example.orderservice.DTO.BookDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
@FeignClient(name = "BOOK-SERVICE")
public interface BookFeign {

    @GetMapping("books/getBookById/{id}")
    public ResponseEntity<?> getBooksById(@PathVariable("id")Integer id);

    @GetMapping("books/getBook/by-ids")
    public List<BookDTO> getBooksByIds(@RequestParam("ids") List<Integer> ids);
}

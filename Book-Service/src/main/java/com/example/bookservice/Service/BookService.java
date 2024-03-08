package com.example.bookservice.Service;

import com.example.bookservice.DTO.BookDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    ResponseEntity<?> addbooks(BookDTO bookDTO);

    ResponseEntity<?> getAllBooks();

    ResponseEntity<?> getBooksById(Integer id);

    ResponseEntity<?> deleteById(Integer id);

    List<BookDTO> getBooksByIds(List<Integer> ids);

}

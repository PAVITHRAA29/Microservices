package com.example.bookservice.Implementation;

import com.example.bookservice.DTO.BookDTO;
import com.example.bookservice.Model.BookEntity;
import com.example.bookservice.Repository.BookRepo;
import com.example.bookservice.Service.BookService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookImplementation implements BookService {

    private final BookRepo bookRepo;

    @Override
    public ResponseEntity<?> addbooks(BookDTO bookDTO) {
        BookEntity bookEntity = BookEntity.builder()
                .Name(bookDTO.getName())
                .Author(bookDTO.getAuthor())
                .build();
        BookEntity book = bookRepo.save(bookEntity);
        return ResponseEntity.ok(book);
    }

    @Override
    public ResponseEntity<?> getAllBooks() {
        List<BookEntity> bookEntityList = bookRepo.findAll(Sort.by("id").ascending());
        return ResponseEntity.ok(bookEntityList);
    }

    @Override
    public ResponseEntity<?> getBooksById(Integer id) {
        Optional<BookEntity> bookEntityList = bookRepo.findById(id);
        return ResponseEntity.ok(bookEntityList);
    }

    @Override
    public ResponseEntity<?> deleteById(Integer id) {
        if (bookRepo.existsById(id)) {
            bookRepo.deleteById(id);
            return ResponseEntity.ok("Book Deleted");
        } else {
            return ResponseEntity.badRequest().body("Book not found");
        }
    }

    @Override
    public List<BookDTO> getBooksByIds(List<Integer> ids) {
        List<BookEntity> books = bookRepo.findByIdIn(ids);
        return books.stream()
                .map(bookEntity -> BookDTO.builder()
                        .id(bookEntity.getId())
                        .Name(bookEntity.getName())
                        .Author(bookEntity.getAuthor())
                        .build())
                .collect(Collectors.toList());
    }
}

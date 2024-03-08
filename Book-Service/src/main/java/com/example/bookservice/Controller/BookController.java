package com.example.bookservice.Controller;

import com.example.bookservice.DTO.BookDTO;
import com.example.bookservice.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    //Load Balancing
//    @Autowired
//    Environment environment;

    @PostMapping("/add")
    public ResponseEntity<?> addbooks(@RequestBody BookDTO bookDTO){
        return bookService.addbooks(bookDTO);
    }

    @GetMapping("/getAllBooks")
    public ResponseEntity<?> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/getBookById/{id}")
    public ResponseEntity<?> getBooksById(@PathVariable("id")Integer id){
        return bookService.getBooksById(id);
    }

    @GetMapping("getBook/by-ids")
    public List<BookDTO> getBooksByIds(@RequestParam("ids") List<Integer> ids) {
//        System.out.println(environment.getProperty("local.server.port"));
        return bookService.getBooksByIds(ids);
    }

    @DeleteMapping("/deleteBookById/{id}")
    public ResponseEntity<?> deleteBooksById(@PathVariable("id")Integer id){
        return bookService.deleteById(id);
    }
}

package com.example.bookservice.Repository;

import com.example.bookservice.Model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<BookEntity, Integer> {
    List<BookEntity> findByIdIn(List<Integer> ids);
}

package com.mal.springbooklib.repository;

import com.mal.springbooklib.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookModel, Long>{
    public List<BookModel> findByTitle(String title);
}


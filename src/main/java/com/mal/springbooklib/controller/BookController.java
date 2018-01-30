package com.mal.springbooklib.controller;

import com.mal.springbooklib.model.BookModel;
import com.mal.springbooklib.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    BookRepository bookRepository;

    // Get All Books
    @GetMapping("/books")
    public List<BookModel> getAllBooks(){
        return bookRepository.findAll();
    }

    // Create a new Book
    @PostMapping("/books")
    public BookModel createBook(@Valid @RequestBody BookModel bookModel){
        return bookRepository.save(bookModel);
    }

    // Get a Single Book
    @GetMapping("/books/{id}")
    public ResponseEntity<BookModel> getBookById(@PathVariable(value="id") Long bookId){
        BookModel bookModel=bookRepository.findOne(bookId);
        if(bookModel == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(bookModel);
    }
    // Update a Book
    @PutMapping("books/{id}")
    public ResponseEntity<BookModel> updateNote(@PathVariable(value="id") Long bookId, @Valid @RequestBody BookModel bookDetails){
        BookModel bookModel = bookRepository.findOne(bookId);
        if (bookModel==null){
            return ResponseEntity.notFound().build();
        }
        bookModel.setTitle(bookDetails.getTitle());
        bookModel.setAuthor(bookDetails.getAuthor());
        bookModel.setDescription(bookDetails.getDescription());

        BookModel updatedBook = bookRepository.save(bookModel);
        return ResponseEntity.ok(updatedBook);
    }

    // Delete a Book
    @DeleteMapping("/books/{id}")
    public ResponseEntity<BookModel> deleteBook(@PathVariable(value="id") Long bookId){
        BookModel bookModel = bookRepository.findOne(bookId);
        if (bookModel==null){
            return ResponseEntity.notFound().build();
        }
        bookRepository.delete(bookModel);
        return ResponseEntity.ok().build();
    }

}

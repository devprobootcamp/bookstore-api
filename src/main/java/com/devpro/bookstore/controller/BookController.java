package com.devpro.bookstore.controller;

import com.devpro.bookstore.dto.Book;
import com.devpro.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/bookstore")
public class BookController {


    private BookService bookService; //dependency

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book/{ibns}")
    public ResponseEntity<Book> getBook(@PathVariable String ibns) {
        return new ResponseEntity<>(bookService.getBook(ibns), HttpStatus.OK);
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @DeleteMapping("/book/{ibns}")
    public ResponseEntity<Void> deleteBook(@PathVariable String ibns) {
        bookService.deleteBook(ibns);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/book")
    public ResponseEntity<Void> addBooks(@RequestBody Book book) {
        bookService.addBook(book);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/book/{ibns}")
    public ResponseEntity<String> updateBook(@PathVariable String ibns, @RequestBody Book book) {
        Boolean updateBook = bookService.updateBook(ibns, book);
        if (updateBook) {
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed", HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBook(@RequestParam String author, @RequestParam String title) {
        return new ResponseEntity<>(bookService.searchBooks(author, title), HttpStatus.OK);
    }


    //200 OK
    //204 success no response body
    // 404 Not found

    // CRUD operations
    // create book - Post
    //retrieve a book /retrieve All books - Get
    // Update Book - Put
    // Delete book -  Delete


}

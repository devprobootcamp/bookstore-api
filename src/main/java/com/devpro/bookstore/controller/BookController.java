package com.devpro.bookstore.controller;

import com.devpro.bookstore.dto.Book;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/bookstore")
public class BookController {


    private static Map<String, Book> bookMap = new HashMap<>();

    public BookController() {
        Book book1 = new Book("Learning java", "12345", "Lewis");
        Book book2 = new Book("Learning SQL", "54321", "Eddy");
        Book book3 = new Book("Learning CSS", "98765", "Kiffa");
        Book book4 = new Book("Learning HTML", "00009", "Cynthia");
        bookMap.put("12345", book1);
        bookMap.put("54321", book2);
        bookMap.put("98765", book3);
        bookMap.put("00009", book4);
    }

    @GetMapping("/book/{ibns}")
    public Book getBook( @PathVariable String ibns){
        return bookMap.get(ibns);
    }

    @GetMapping("/books")
    public List<Book> getBooks(){
        return List.copyOf(bookMap.values());
    }

    @DeleteMapping("/book/{ibns}")
    public void deleteBook( @PathVariable String ibns){
        bookMap.remove(ibns);
    }

    @PostMapping("/book")
    public void addBooks(@RequestBody Book book){
        bookMap.put(book.getIbns(), book);
    }




}

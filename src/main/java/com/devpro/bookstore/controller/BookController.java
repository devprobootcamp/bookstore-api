package com.devpro.bookstore.controller;

import com.devpro.bookstore.dto.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Book> getBook( @PathVariable String ibns){
        return new ResponseEntity<>(bookMap.get(ibns), HttpStatus.OK);
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(){
        return new ResponseEntity<>(List.copyOf(bookMap.values()), HttpStatus.OK);
    }

    @DeleteMapping("/book/{ibns}")
    public ResponseEntity<Void> deleteBook( @PathVariable String ibns){
        bookMap.remove(ibns);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/book")
    public ResponseEntity<Void> addBooks(@RequestBody Book book){
        bookMap.put(book.getIbns(), book);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/book/{ibns}")
    public ResponseEntity<String> updateBook(@PathVariable String ibns, @RequestBody Book book){
        Book oldData = bookMap.get(ibns);
        if(oldData != null){
            bookMap.put(ibns, book);
//            return  ResponseEntity.ok("Success");
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } else {
//            return  ResponseEntity.notFound().build();
            return new ResponseEntity<>("Failed", HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBook(@RequestParam String author, @RequestParam String title){

        List<Book> res = new ArrayList<>();
//        List<Book> books = List.copyOf(bookMap.values());
//        for(int i =0; i<books.size(); i++){
//            Book bk = books.get(i);
//            if(bk.getAuthor().contains(author) && bk.getTitle().contains(title)){
//                res.add(bk);
//            }
//        }
        for(Book bk: bookMap.values()){
            if(bk.getAuthor().contains(author) && bk.getTitle().contains(title)){
                res.add(bk);
            }
        }

        return new ResponseEntity<>(res, HttpStatus.OK);
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

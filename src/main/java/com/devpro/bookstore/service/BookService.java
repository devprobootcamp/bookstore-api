package com.devpro.bookstore.service;

import com.devpro.bookstore.dto.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {

    private static Map<String, Book> bookMap = new HashMap<>();

    public BookService() {
        Book book1 = new Book("Learning java", "12345", "Lewis");
        Book book2 = new Book("Learning SQL", "54321", "Eddy");
        Book book3 = new Book("Learning CSS", "98765", "Kiffa");
        Book book4 = new Book("Learning HTML", "00009", "Cynthia");
        bookMap.put("12345", book1);
        bookMap.put("54321", book2);
        bookMap.put("98765", book3);
        bookMap.put("00009", book4);
    }

    public List<Book> getAllBooks() {
        return List.copyOf(bookMap.values());
    }

    public List<Book> searchBooks(String author, String title) {
        List<Book> res = new ArrayList<>();
        for(Book bk: bookMap.values()){
            if(bk.getAuthor().contains(author) && bk.getTitle().contains(title)){
                res.add(bk);
            }
        }
        return res;
    }

    public void addBook(Book book) {
        bookMap.put(book.getIbns(), book);
    }

    public Book getBook(String ibns) {
        return bookMap.get(ibns);
    }

    public void deleteBook(String ibns) {
        bookMap.remove(ibns);
    }

    public Boolean updateBook(String ibns, Book book) {
        Book oldData = bookMap.get(ibns);
        if (oldData != null) {
            bookMap.put(ibns, book);
            return true;

        } else {
            return false;
        }
    }



}

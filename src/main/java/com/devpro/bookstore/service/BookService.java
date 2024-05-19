package com.devpro.bookstore.service;

import com.devpro.bookstore.dto.Book;
import com.devpro.bookstore.model.BookEntity;
import com.devpro.bookstore.repository.BookEntityRepository;
import com.devpro.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {


    private BookRepository bookRepository; // Dependecy

    private BookEntityRepository bookEntityRepository; //dependency

    @Autowired // Dependency injection
    public BookService(BookRepository bookRepository, BookEntityRepository bookEntityRepository) {
        this.bookRepository = bookRepository;
        this.bookEntityRepository = bookEntityRepository;
    }


    public List<BookEntity> getBooks() {
        return bookEntityRepository.findAll();
    }

    public BookEntity getABooks(String ibns) {
        Optional<BookEntity> optionalBook = bookEntityRepository.findById(ibns);
        if(optionalBook.isEmpty()){
           throw new RuntimeException("No book found!!!!");
        }
        return optionalBook.get();
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> searchBooks(String author, String title) {
        return bookRepository.searchBooks(author, title);
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public Book getBook(String ibns) {
        return bookRepository.findBook(ibns);
    }

    public void deleteBook(String ibns) {
        bookRepository.deleteBook(ibns);
    }

    public Boolean updateBook(String ibns, Book book) {
        Book oldData = bookRepository.findBook(ibns);
        if (oldData != null) {
            bookRepository.updateBook(ibns, book);
            return true;
        }
        return false;
    }


}

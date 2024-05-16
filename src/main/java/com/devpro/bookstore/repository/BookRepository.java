package com.devpro.bookstore.repository;

import com.devpro.bookstore.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //CRUD operation

    public void save(Book book) {
        String sql = "INSERT into books(ibns, author, title) values (?, ?, ?)";
        jdbcTemplate.update(sql, book.getIbns(), book.getAuthor(), book.getTitle());
    }

    public List<Book> findAll() {
        String sql = "SELECT * FROM books;";
        List<Book> books = jdbcTemplate.query(sql, new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                String title = rs.getString("title");
                String ibns = rs.getString("ibns");
                String author = rs.getString("author");

                Book book = new Book(title, ibns, author);
                return book;
            }
        });

        return books;
    }

    public Book findBook(String ibns) {
        String sql = "SELECT * FROM books WHERE ibns=?";
        List<Book> books = jdbcTemplate.query(sql, new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                Book book = new Book(rs.getString("title"), rs.getString("ibns"), rs.getString("author"));
                return book;
            }
        }, ibns);

        return books.get(0);
    }

    public List<Book> searchBooks(String author, String title) {

        String sql = "SELECT * FROM books where author like %" + author + "% and title like %" + title + "%";
        List<Book> books = jdbcTemplate.query(sql, new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                Book book = new Book(rs.getString("title"), rs.getString("ibns"), rs.getString("author"));
                return book;
            }
        });

        return books;
    }

    public void updateBook(String ibns, Book book) {
        String sql = "UPDATE books SET author=" + book.getAuthor() + ", title=" + book.getTitle() + " WHERE ibns = " + ibns;
        jdbcTemplate.update(sql, book.getIbns(), book.getAuthor(), book.getTitle());
    }

    public void deleteBook(String ibns) {
        String sql = "DELETE FROM books WHERE ibns = " + ibns;
        jdbcTemplate.execute(sql);
    }
}

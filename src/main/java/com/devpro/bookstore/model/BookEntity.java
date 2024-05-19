package com.devpro.bookstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "books")
@Data
public class BookEntity {

    @Id
    private String ibns;
    private String title;

    @Column(name = "author")
    private String authorName;

}

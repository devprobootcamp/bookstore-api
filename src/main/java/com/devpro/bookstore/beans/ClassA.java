package com.devpro.bookstore.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Scope("prototype")
public class ClassA {

    private LocalDateTime dateTime;

    public ClassA() {
        this.dateTime = LocalDateTime.now();
        System.err.println("I am being created..."+dateTime);
    }

    public String helloA() {
        return "HelloA@" + this.dateTime;
    }
}



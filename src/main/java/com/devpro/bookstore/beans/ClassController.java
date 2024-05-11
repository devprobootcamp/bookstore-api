package com.devpro.bookstore.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClassController {

    @Autowired
    private ClassA classA; //dependency
    @Autowired
    private ClassB classB; //dependency


    @GetMapping("/class")
    public ResponseEntity<String> get(){
        String helloB = classB.helloB();
        return new ResponseEntity<>(helloB, HttpStatus.OK);
    }
}


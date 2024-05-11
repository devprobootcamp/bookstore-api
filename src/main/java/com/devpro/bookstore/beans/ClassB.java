package com.devpro.bookstore.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassB {

    @Autowired
    private ClassA classA; //dependency

    @Autowired
    public void setClassA(ClassA classA) {
        this.classA = classA;
        System.err.println("I am being injected"+ this.classA.helloA());
    }

    public String helloB(){
        return classA.helloA();
    }
}



package com.devpro.bookstore.dto;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(12);
        queue.add(77);
        System.out.println(queue.peek());
        queue.poll();
        System.out.println(queue.peek());
    }
}

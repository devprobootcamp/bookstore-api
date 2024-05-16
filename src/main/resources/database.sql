CREATE DATABASE bookstore2;
USE bookstore2;

CREATE TABLE books(
ibns varchar(255) primary key,
title varchar(255) not null,
author varchar(255) not null
);
package ru.geekbrains.java3_lesson3_client_server;

import java.io.Serializable;

public class Book implements Serializable{
    private String title;

    public Book(String title) {
        this.title = title;
    }

@Override
public String toString(){
    return "Book" + title;
    }
}
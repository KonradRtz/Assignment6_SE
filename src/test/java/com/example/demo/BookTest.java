package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.demo.Catalog.Book;

public class BookTest {
    @Test
    void testBookConstructorGettersAndSetters(){
        Book testBook = new Book("123", "Lord of the Rings", "JK Rowling", "20000000");
        assertEquals("JK Rowling",testBook.getAuthor());
        assertEquals("123",testBook.getId());
        assertEquals("20000000",testBook.getPublicationYear());
        assertEquals("Lord of the Rings",testBook.getTitle());
        testBook.setAuthor("Konrad Clemens");
        testBook.setId("838");
        testBook.setPublicationYear("984");
        testBook.setTitle("Lord of the Flies");
        assertEquals("Konrad Clemens",testBook.getAuthor());
        assertEquals("838",testBook.getId());
        assertEquals("984",testBook.getPublicationYear());
        assertEquals("Lord of the Flies",testBook.getTitle());
    }
}

package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.Catalog.Book;
import com.example.demo.Catalog.Catalog;

public class CatalogTest {
    
    private Catalog testCatalog;

    @BeforeEach
    public void setUp() {
        testCatalog = new Catalog();
        testCatalog.createBook("123", "Lord of the Flies", "Kasper", "1984");
        testCatalog.createBook("321", "Lord of the Rings", "Konrad", "0000");
        testCatalog.createBook("001", "Lord of the Tables", "Kasper" , "1999");
    }

    @Test
    void testReadBookByIdentifier(){
        Book book = testCatalog.readBookByID("123");
        assertEquals("123", book.getId());
        assertEquals("Lord of the Flies", book.getTitle());
        assertEquals("Kasper", book.getAuthor());
        assertEquals("1984", book.getPublicationYear());
    }

    @Test
    void testReadBookByAuthor(){
        ArrayList<Book> books = testCatalog.readBooksByAuthor("Kasper");
        assertEquals("123", books.get(0).getId());
        assertEquals("Lord of the Flies", books.get(0).getTitle());
        assertEquals("Kasper", books.get(0).getAuthor());
        assertEquals("1984", books.get(0).getPublicationYear());
        assertEquals("001", books.get(1).getId());
        assertEquals("Lord of the Tables", books.get(1).getTitle());
        assertEquals("Kasper", books.get(1).getAuthor());
        assertEquals("1999", books.get(1).getPublicationYear());
    }

    @Test
    void testReadBookByPublicationYear(){
        ArrayList<Book> books = testCatalog.readBooksByYear("1999");
        Book book = books.get(0);
        assertEquals("001", book.getId());
        assertEquals("Lord of the Tables", book.getTitle());
        assertEquals("Kasper", book.getAuthor());
        assertEquals("1999", book.getPublicationYear());
    }

    @Test
    void testReadBookByTitle(){
        ArrayList<Book> books = testCatalog.readBooksByTitle("Lord of the Rings");
        Book book = books.get(0);
        assertEquals("321", book.getId());
        assertEquals("Lord of the Rings", book.getTitle());
        assertEquals("Konrad", book.getAuthor());
        assertEquals("0000", book.getPublicationYear());
    }

    @Test
    void testReadBookByFalseID() {
        Book book = testCatalog.readBookByID("9393939393");
        assertNull(book);
    }

    @Test
    void testUpdateBookIdentifier(){
        testCatalog.updateBookIdentifier("123", "555");
        assertEquals("Kasper", testCatalog.readBookByID("555").getAuthor());
    }

    @Test
    void testUpdateBookAuthor(){
        testCatalog.updateBookAuthor("123", "Olaf");
        assertEquals("Olaf", testCatalog.readBookByID("123").getAuthor());
    }

    @Test
    void testUpdateBookPublicationYear(){
        testCatalog.updateBookPublicationYear("123", "7777");
        assertEquals("7777", testCatalog.readBookByID("123").getPublicationYear());
    }

    @Test
    void testUpdateBookTitle(){
        testCatalog.updateBookTitle("123", "Olaf");
        assertEquals("Olaf", testCatalog.readBookByID("123").getTitle());
    }
}

package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;

import com.example.demo.BookInventory.Book;
import com.example.demo.BookInventory.Inventory;

public class InventoryTest {
    private Inventory testInventory;

    @BeforeEach
    public void setUp() {
        testInventory = new Inventory();
    }

    @Test
    void testAddNewBookToInventory(){
        Book testBook = new Book("001", "Lord of the Kings", "Thomas", "1234");
        testInventory.addBook(testBook, 999);
        assertEquals(999,testInventory.getInventory().get(testBook));
    }

    @Test
    void testChangeQuantity(){
        Book testBook = new Book("001", "Lord of the Kings", "Thomas", "1234");
        testInventory.addBook(testBook, 999);
        testInventory.changeQuantity(testBook, 0);
        assertEquals(0,testInventory.getInventory().get(testBook));
    }

    @Test
    void testIsAvailable(){
        Book testBook = new Book("001", "Lord of the Kings", "Thomas", "1234");
        testInventory.addBook(testBook, 999);
        assertTrue(testInventory.isAvalaible(testBook));
    }

    @Test
    void getQuantity(){
        Book testBook = new Book("001", "Lord of the Kings", "Thomas", "1234");
        testInventory.addBook(testBook, 999);
        assertEquals(999,testInventory.getQuantity(testBook));
    }
}

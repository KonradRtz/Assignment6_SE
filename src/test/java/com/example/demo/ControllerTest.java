package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

import com.example.demo.BookOrder.OrderController;
import com.example.demo.BookOrder.Book;

public class ControllerTest {

    @Test
    void testOrderController(){
        OrderController testOrderController = new OrderController();
        testOrderController.orderBook(new Book("001", "Yes", "ME", "1901"), 100);
        assertEquals(100,testOrderController.getOrders().get(0).getOrderQuantity());
    }
}

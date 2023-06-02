package com.example.demo.BookOrder;

import java.util.ArrayList;

public class OrderController {
    
    private ArrayList<Order> orders;

    public void orderBook(Book book, int orderQuantity){
        Order currentOrder = new Order(book,orderQuantity, String.valueOf(System.currentTimeMillis()));
        orders.add(currentOrder);
        // when the order is placed also remove this quantity through the api
    }

    public ArrayList<Order> getOrders(){
        return orders;
    }

    public OrderController(){
        orders = new ArrayList<>();
    }
}

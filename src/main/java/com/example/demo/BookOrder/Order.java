package com.example.demo.BookOrder;

public class Order {
    
    private Book bookOrdered;
    private int orderQuantity;
    private String orderDate;

    public Order(Book bookOrdered, int orderQuantity, String orderDate){
        this.bookOrdered = bookOrdered;
        this.orderQuantity = orderQuantity;
        this.orderDate = orderDate;
    }

    public Book getBookOrdered(){
        return this.bookOrdered;
    }

    public int getOrderQuantity(){
        return this.orderQuantity;
    }

    public String getOrderDate(){
        return this.orderDate;
    }
}

package com.example.demo.BookOrder;
<<<<<<< Updated upstream

import java.util.ArrayList;

public class OrderController {
    
    private ArrayList<Order> orders;

    public void orderBook(Book book, int orderQuantity){
        Order currentOrder = new Order(book,orderQuantity, String.valueOf(System.currentTimeMillis()));
        orders.add(currentOrder);
        // when the order is placed also remove this quantity through the api
=======
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private ArrayList<Order> orders = new ArrayList<>();

    @PostMapping("/bookorder")
    public void orderBook(String bookId, int orderQuantity, String date){
        Order newOrder = new Order(bookId, orderQuantity, date);
        orders.add(newOrder);
>>>>>>> Stashed changes
    }

    public ArrayList<Order> getOrders(){
        return orders;
    }
<<<<<<< Updated upstream

    public OrderController(){
        orders = new ArrayList<>();
    }
=======
>>>>>>> Stashed changes
}

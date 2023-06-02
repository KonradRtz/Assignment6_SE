package com.example.demo.BookOrder;
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
    public void orderBook(Book book, int orderQuantity, String date){
        Order newOrder = new Order(book, orderQuantity, date);
        orders.add(newOrder);
    }

    public ArrayList<Order> getOrders(){
        return orders;
    }
}

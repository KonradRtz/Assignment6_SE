package com.example.demo.BookInventory;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.Enumeration;
import java.util.HashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@RestController
@RequestMapping("/inventory")
public class Inventory {
        // when added to catalog the initial value should set here as well, this has to be done with api i think

        HashMap<Book, Integer> inventoryList;

        public Inventory(){
            this.inventoryList = new HashMap<>();
        }
    
        @GetMapping("/getInventoty")
        public HashMap<Book, Integer> getInventory(){
            return this.inventoryList;
        }
    
        @PostMapping("/addBook")
        public void addBook(Book book, int quantity){
            inventoryList.put(book, quantity);
        }
    
        @PostMapping("/changeQuantity")
        public void changeQuantity(Book book, int newQuantity){
            if(inventoryList.containsKey(book)){
                inventoryList.put(book, newQuantity);
            }
        }
    
        @GetMapping("/quantityOfBook")
        public int getQuantity(Book book){
            return inventoryList.get(book);
        }
    
        @GetMapping("/isAvailable")
        public boolean isAvalaible(Book book){
            return inventoryList.containsKey(book) ;
        }
}

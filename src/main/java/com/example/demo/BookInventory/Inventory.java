package com.example.demo.BookInventory;

import java.util.HashMap;

public class Inventory {
        // when added to catalog the initial value should set here as well, this has to be done with api i think

        HashMap<Book, Integer> inventoryList;

        public Inventory(){
            this.inventoryList = new HashMap<>();
        }
    
        public HashMap<Book, Integer> getInventory(){
            return this.inventoryList;
        }
    
        public void addBook(Book book, int quantity){
            inventoryList.put(book, quantity);
        }
    
        public void changeQuantity(Book book, int newQuantity){
            if(inventoryList.containsKey(book)){
                inventoryList.put(book, newQuantity);
            }
        }
    
        public int getQuantity(Book book){
            return inventoryList.get(book);
        }
    
        public boolean isAvalaible(Book book){
            return inventoryList.containsKey(book) ;
        }
}

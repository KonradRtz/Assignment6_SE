package com.example.demo.Catalog;

import java.util.ArrayList;

public class Catalog {
    private ArrayList<Book> books;

    public Catalog(){
        books = new ArrayList<>();
    }

    public void createBook(String identificationCode, String title, String author, String publicationYear){
        Book newBook = new Book(identificationCode, title, author, publicationYear);
        books.add(newBook);
    }
    
    public ArrayList<Book> getCatalog(){
        return books;
    }

    public Book readBookByID(String identifier){
        for(Book book:books){
            if(book.getId().equals(identifier)){
                return book;
            }
        }
        return null;
    }

    public ArrayList<Book> readBooksByAuthor(String author){
        ArrayList<Book> newBooks = new ArrayList<>();
        for(Book book: books){
            if(book.getAuthor().equals(author)){
                newBooks.add(book);
            }
        }
        if(newBooks.isEmpty()){
            return null;
        } else {
            return newBooks;
        }
    }

    public ArrayList<Book> readBooksByYear(String year){
        ArrayList<Book> newBooks = new ArrayList<>();
        for(Book book: books){
            if(book.getPublicationYear().equals(year)){
                newBooks.add(book);
            }
        }
        if(newBooks.isEmpty()){
            return null;
        } else {
            return newBooks;
        }
    }

    public ArrayList<Book> readBooksByTitle(String title){
        ArrayList<Book> newBooks = new ArrayList<>();
        for(Book book: books){
            if(book.getTitle().equals(title)){
                newBooks.add(book);
            }
        }
        if(newBooks.isEmpty()){
            return null;
        } else {
            return newBooks;
        }
    }

    public void updateBookIdentifier(String currentId, String newId){
        readBookByID(currentId).setId(newId);
    }

    public void updateBookTitle(String currentId, String newTitle){
        readBookByID(currentId).setTitle(newTitle);
    }

    public void updateBookAuthor(String currentId, String newAuthor){
        readBookByID(currentId).setAuthor(newAuthor);
    }

    public void updateBookPublicationYear(String currentId, String newYear){
        readBookByID(currentId).setPublicationYear(newYear);
    }

    public void deleteBook(String id){
        books.remove(readBookByID(id));
    }
}

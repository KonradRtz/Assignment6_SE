package com.example.demo.BookCatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalogue")
public class Catalog {

    private ArrayList<Book> books;

    @PostMapping("/addBook")
    public void createBook(String identificationCode, String title, String author, String publicationYear){
        Book newBook = new Book(identificationCode, title, author, publicationYear);
        books.add(newBook);
    }

    @GetMapping("/readBooksByID")
    public Book readBookByID(String identifier){
        for(Book book:books){
            if(book.getId().equals(identifier)){
                return book;
            }
        }
        return null;
    }

    @GetMapping("/readBookByAuthor")
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

    @GetMapping("/readBooksByYear")
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

    @GetMapping("/readyBookByTitle")
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

    @PutMapping("/updateID")
    public void updateBookIdentifier(String currentId, String newId){
        readBookByID(currentId).setId(newId);
    }

    @PutMapping("/updateTitle")
    public void updateBookTitle(String currentId, String newTitle){
        readBookByID(currentId).setTitle(newTitle);
    }

    @PutMapping("/updateAuthor")
    public void updateBookAuthor(String currentId, String newAuthor){
        readBookByID(currentId).setAuthor(newAuthor);
    }

    @PutMapping("/updateYear")
    public void updateBookPublicationYear(String currentId, String newYear){
        readBookByID(currentId).setPublicationYear(newYear);
    }

    @DeleteMapping("/deleteBook")
    public void deleteBook(String id){
        books.remove(readBookByID(id));
    }

}

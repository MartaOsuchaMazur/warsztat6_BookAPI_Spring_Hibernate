package pl.coderslab.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.service.BookService;
import pl.coderslab.model.Book;


import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    
//    GET 	/books 	Zwraca listę wszystkich książek.

    @GetMapping("")
    public List<Book> getList() {
        return bookService.getBooks();
    }


/*
POST 	/books 	Tworzy nową książkę na podstawie danych przekazanych z formularza i zapisuje ją do bazy danych.
    PostMapping("")
    public void addBook(@RequestBody Book book) {
        bookService.add(book);
    }
*/

    @GetMapping("/add")
    public String addBook() {
        return "addBook";
    }

    @PostMapping ("/add")
    public String add(@RequestParam String isbn, @RequestParam String title, @RequestParam String author,
                      @RequestParam String publisher, @RequestParam String type) {
        Book newBook = new Book(0L, isbn, title, author, publisher, type);
        bookService.add(newBook);
        return "Book added!";
    }

// GET 	/books/{id} 	Wyświetla informacje o książce o podanym id.

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return this.bookService.get(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        });
    }


// DELETE 	/books/{id} 	Usuwa książkę o podanym id z bazy danych.

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        this.bookService.delete(id);
    }

// PUT 	/books 	Zmienia informacje o książce o podanym id na nową.

    @PutMapping("")
    public void updateBook(@RequestBody Book book){
        bookService.update(book);
    }

}

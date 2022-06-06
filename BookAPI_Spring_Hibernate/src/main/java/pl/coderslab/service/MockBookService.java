package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MockBookService implements BookService {

    private List<Book> books;
    private static Long nextId = 5L;

    public MockBookService(List<Book> books) {
        this.books = books;
    }

    public MockBookService() {
        books = new ArrayList<>();
        books.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        books.add(new Book(2L, "9788328369566", "Java Zadania z programowania z przykładowymi rozwiązaniami", "Mirosław Kubiak", "Helion", "programming"));
        books.add(new Book(3L, "9788377883822", "Koreański nie gryzie!", "Anna Diniejko", "EDGARD", "lenguage learning"));
        books.add(new Book(4L, "9788395452840", "JavaScript od podstaw", "Marcin Moskała", "Mazowieckie Centrum Poligrafii", "programming"));
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public void add(Book book) {
        book.setId(nextId++);
        books.add(book);
    }

    @Override
    public Optional<Book> get(Long id) {
        return books.stream().filter(item -> item.getId().equals(id)).findFirst();
    }

    @Override
    public void delete(Long id) {
        if (get(id).isPresent()) {
            books.remove(this.get(id).get());
        }
    }

    @Override
    public void update(Book book) {
        if (this.get(book.getId()).isPresent()) {
            int indexOf = books.indexOf(this.get(book.getId()).get());
            books.set(indexOf, book);
        }
    }


    public static Long setNextId(Long nextId) {
        return MockBookService.nextId = nextId;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public static Long getNextId() {
        return nextId;
    }

}

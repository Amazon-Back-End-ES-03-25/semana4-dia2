package com.ironhack.semana4_dia2.controller;

import com.ironhack.semana4_dia2.model.Book;
import com.ironhack.semana4_dia2.model.Category;
import com.ironhack.semana4_dia2.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/search")
    public List<Book> searchBooksByAuthor(@RequestParam(required = false) String author) {
        return bookService.searchBooksByAuthor(author);
    }

    @GetMapping("/filter")
    public List<Book> filterBooks(
            @RequestParam(required = false) List<Category> categories,
            @RequestParam(defaultValue = "0") int minPages,
            @RequestParam(defaultValue = "1000") int maxPages
    ) {
        return bookService.filterBooks(categories, minPages, maxPages);
    }
}

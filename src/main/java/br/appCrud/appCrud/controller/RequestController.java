package br.appCrud.appCrud.controller;

import br.appCrud.appCrud.entities.Book;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class RequestController {
    private Integer counter = 0;
    private HashMap<Integer, Book> books = new HashMap<>();

    @GetMapping("/books")
    public HashMap<Integer, Book> getAllBooks() {
        return books;
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable("id") Integer id) {
        return books.get(id);
    }

    @PostMapping("/books")
    public String setBook(@RequestBody Book book) {
        book.setId(counter++);
        books.put(book.getId(), book);
        return "Livro Cadastrado!";
    }

    @DeleteMapping("/books/{id}")
    public String deleteBookById(@PathVariable("id") Integer id) {
        Book removeBook =  books.remove(id);
        if (removeBook != null) {
            return "Livro Deletado!";
        }

        return "O Livro não existe!";
    }

    @PutMapping("/books/{id}")
    public String updateBookById(@PathVariable("id") Integer id, @RequestBody Book newBook) {
        Book book = books.get(id);
        if (book == null) {
            return "Livro não encontrado!";
        }

        book.setName(newBook.getName());
        book.setAuthor(newBook.getAuthor());

        return "Dados do Livro atualizados!";

    }
}

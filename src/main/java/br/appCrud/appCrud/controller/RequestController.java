package br.appCrud.appCrud.controller;

import br.appCrud.appCrud.entities.Book;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class RequestController {
    private Integer counter = 0;
    private HashMap<Integer, Book> books = new HashMap<>();

    @GetMapping("/getbooks")
    public HashMap<Integer, Book> getBooks() {
        return books;
    }

    @GetMapping("/getbook")
    public Book getBook(@RequestParam(value = "id") Integer id) {
        return books.get(id);
    }

    @PostMapping("/setbook")
    public String setBook(@RequestBody Book book) {
        book.setId(counter++);
        books.put(book.getId(), book);
        return "Cadastrado! Livro: " + book.getName();
    }

    @DeleteMapping("/delbook")
    public String delBook(@RequestParam (value = "id") Integer id) {
        Book removeBook =  books.remove(id);
        if (removeBook != null) {
            return "Livro Deletado!";
        }

        return "Livro não existe!";
    }

    @PutMapping("/updbook")
    public String updBook(@RequestParam (value = "id") Integer id, @RequestBody Book newBook) {
        Book book = books.get(id);
        if (book == null) {
            return "Livro não encontrado!";
        }

        book.setName(newBook.getName());
        book.setAuthor(newBook.getAuthor());

        return "Dados do Livro atualizados!";

    }
}

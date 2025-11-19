package br.appCrud.appCrud.controller;

import br.appCrud.appCrud.entities.Book;
import br.appCrud.appCrud.entities.BulkDeleteRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/books")
public class RequestController {
    private Integer counter = 0;
    private HashMap<Integer, Book> books = new HashMap<>();

    @GetMapping
    public HashMap<Integer, Book> getAllBooks() {
        return books;
    }

    @GetMapping("{id}")
    public Book getBookById (@PathVariable("id") Integer id) {
        return books.get(id);
    }

    @PostMapping
    public String setBook (@RequestBody Book book) {
        book.setId(counter++);
        books.put(book.getId(), book);
        return "Livro Cadastrado!";
    }

    @PostMapping("/bulk-delete")
    public List<String> bulkDelete(@RequestBody BulkDeleteRequest ids) {
        List<String> names = new ArrayList<>();
        List<Integer> idBooks = ids.getIds();

        for (int i = 0; i < idBooks.size(); i++) {
            Book book = books.get(idBooks.get(i));
            if (book == null) {
                names.add("NÃO ENCONTRADO");

            } else {
                names.add("DELETADO");
                books.remove(idBooks.get(i));
            }
        }
        return names;
    }

    @DeleteMapping("{id}")
    public String deleteBookById (@PathVariable("id") Integer id) {
        Book removeBook =  books.remove(id);
        if (removeBook != null) {
            return "Livro Deletado!";
        }

        return "O Livro não existe!";
    }

    @PutMapping("{id}")
    public String updateBookById (@PathVariable("id") Integer id, @RequestBody Book newBook) {
        Book book = books.get(id);
        if (book == null) {
            return "Livro não encontrado!";
        }

        book.setName(newBook.getName());
        book.setAuthor(newBook.getAuthor());

        return "Dados do Livro atualizados!";

    }
}

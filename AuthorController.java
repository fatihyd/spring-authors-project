package com.example.springauthorsproject.controller;

import com.example.springauthorsproject.model.Author;
import com.example.springauthorsproject.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<Author> getAuthorByName(@PathVariable String name) {
        return authorService.findByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        return authorService.findByName(author.getName())
            .map(ResponseEntity::ok) // Yazar zaten varsa, döndür
            .orElseGet(() -> {
                // Yazarı API'den çekmek için AuthorService içinde yeni bir metod
                Author apiAuthor = authorService.fetchAndSaveAuthorFromAPI(author.getName());
                return ResponseEntity.ok(apiAuthor); // Kaydedilen yazarı döndür
            });
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> authors = authorService.findAllAuthors();
        return ResponseEntity.ok(authors);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.ok().build();
    }
}

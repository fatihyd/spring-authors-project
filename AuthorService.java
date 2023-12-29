package com.example.springauthorsproject.service;

import com.example.springauthorsproject.model.Author;
import com.example.springauthorsproject.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public AuthorService(AuthorRepository authorRepository, RestTemplate restTemplate) {
        this.authorRepository = authorRepository;
        this.restTemplate = restTemplate;
    }

    @Transactional(readOnly = true)
    public Optional<Author> findByName(String name) {
        return authorRepository.findByName(name);
    }

    @Transactional
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Transactional(readOnly = true)
    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    @Transactional
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    @Transactional
    public Author fetchAndSaveAuthorFromAPI(String name) {
        String apiUrl = "http://external-api.com/authors/" + name; // API URL'inizi buraya girin
        Author author = restTemplate.getForObject(apiUrl, Author.class);
        if (author != null) {
            return saveAuthor(author);
        } else {
            throw new RuntimeException("Author not found in external API");
        }
    }
}

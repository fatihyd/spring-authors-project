package com.example.springauthorsproject.controller;

import com.example.springauthorsproject.model.Work;
import com.example.springauthorsproject.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/works")
public class WorkController {

    private final WorkService workService;

    @Autowired
    public WorkController(WorkService workService) {
        this.workService = workService;
    }

    @GetMapping("/author/{authorId}")
    public ResponseEntity<List<Work>> getWorksByAuthorId(@PathVariable Long authorId) {
        List<Work> works = workService.findWorksByAuthorId(authorId);
        return ResponseEntity.ok(works);
    }

    @PostMapping
    public ResponseEntity<Work> createWork(@RequestBody Work work) {
        Work savedWork = workService.saveWork(work);
        return ResponseEntity.ok(savedWork);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWork(@PathVariable Long id) {
        workService.deleteWork(id);
        return ResponseEntity.ok().build();
    }
}

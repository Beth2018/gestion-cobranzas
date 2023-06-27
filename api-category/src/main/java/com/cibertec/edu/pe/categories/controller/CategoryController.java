package com.cibertec.edu.pe.categories.controller;

import com.cibertec.edu.pe.categories.dao.entity.Category;
import com.cibertec.edu.pe.categories.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final ICategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> listAll() {
        List<Category> categories = service.listAll();
        if (categories.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<Category> save(@RequestBody Category category) {
        return ResponseEntity.created(URI.create("/api/category" + service.save(category).getId())).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Category> update(@PathVariable("id") Long id, @RequestBody Category category) {
        Category categoryUpd = service.update(id, category);
        if (Objects.isNull(categoryUpd)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(categoryUpd);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

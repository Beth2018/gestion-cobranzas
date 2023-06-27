package com.cibertec.edu.pe.persons.controller;

import com.cibertec.edu.pe.persons.dao.entity.Person;
import com.cibertec.edu.pe.persons.service.IPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor
public class PersonController {

    private final IPersonService service;

    @GetMapping("/findByDoi")
    public ResponseEntity<Person> findByDoi(@RequestParam("doi") String doi) {
        Optional<Person> person = service.findByDoi(doi);
        return person.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @PatchMapping("/:id")
    public ResponseEntity<Person> updateStatusPerson(@PathVariable("id") Long id) {
        Person person = service.updateStatusPerson(id);
        if (person == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(person);
    }
}

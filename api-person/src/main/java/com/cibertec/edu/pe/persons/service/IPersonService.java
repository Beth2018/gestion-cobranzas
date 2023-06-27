package com.cibertec.edu.pe.persons.service;

import com.cibertec.edu.pe.persons.dao.entity.Person;

import java.util.List;
import java.util.Optional;

public interface IPersonService {
    Person updateStatusPerson(Long id);

    Optional<Person> findByDoi(String doi);
}

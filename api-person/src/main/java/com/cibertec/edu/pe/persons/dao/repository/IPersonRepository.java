package com.cibertec.edu.pe.persons.dao.repository;

import com.cibertec.edu.pe.persons.dao.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonRepository extends JpaRepository<Person, Long> {
}

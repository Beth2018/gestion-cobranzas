package com.cibertec.edu.pe.persons.service.impl;

import com.cibertec.edu.pe.persons.client.service.ISbsClient;
import com.cibertec.edu.pe.persons.dao.entity.Person;
import com.cibertec.edu.pe.persons.dao.repository.IPersonRepository;
import com.cibertec.edu.pe.persons.service.IPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements IPersonService {

    private final IPersonRepository repository;
    private final ISbsClient sbsClient;
    private final RedisTemplate<String, Person> redisTemplate;

    @Override
    public Person updateStatusPerson(Long id) {
        Optional<Person> optionalPerson = repository.findById(id);
        if (optionalPerson.isEmpty()) {
            return null;
        }
        Person person = optionalPerson.get();
        person.setStatus("NO ADEUDO");
        return repository.save(person);
    }

    @Override
    public Optional<Person> findByDoi(String doi) {
        ValueOperations<String, Person> valueOperations = redisTemplate.opsForValue();
        Person person = valueOperations.get("PERSON-" + doi);
        if (Objects.nonNull(person)) {
            return Optional.of(person);
        }
        Person personExample = new Person();
        personExample.setDocumentNumber(doi);
        Optional<Person> personOptional = repository.findOne(Example.of(personExample));
        if (personOptional.isPresent()) {
            personOptional.map(person1 -> {
                person1.setSbsReport(sbsClient.getSbsReport(doi));
                valueOperations.set("PERSON-" + doi, person1, Duration.ofMinutes(5));
                return person1;
            });
        }
        return personOptional;
    }
}

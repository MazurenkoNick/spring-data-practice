package com.example.springdataintroduction.service;

import com.example.springdataintroduction.entity.Person;
import com.example.springdataintroduction.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    @Transactional
    public List<Person> getAll() {
        return personRepository.findAllBy();
    }

    @Transactional
    public List<Person> getAllByFirstName(String firstName) {
       return personRepository.findAllByFirstNameFetchNotes(firstName);
    }
}

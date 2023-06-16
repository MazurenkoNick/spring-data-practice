package com.example.springdataintroduction.controller;

import com.example.springdataintroduction.entity.Person;
import com.example.springdataintroduction.repository.PersonRepository;
import com.example.springdataintroduction.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/{firstName}")
    public List<Person> getByFirstName(@PathVariable String firstName) {
        return personService.getAllByFirstName(firstName);
    }

    @GetMapping
    public List<Person> getAll() {
        return personService.getAll();
    }
}

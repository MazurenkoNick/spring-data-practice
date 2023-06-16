package com.example.springdataintroduction.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "persons")
@Getter @Setter @ToString
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @JsonManagedReference
    @Setter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "person")
    private List<Note> notes = new ArrayList<>();
}

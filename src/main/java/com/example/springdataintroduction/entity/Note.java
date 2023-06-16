package com.example.springdataintroduction.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "notes")
@Getter @Setter @ToString
public class Note {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String body;

    @JsonBackReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "person_id")
    private Person person;
}

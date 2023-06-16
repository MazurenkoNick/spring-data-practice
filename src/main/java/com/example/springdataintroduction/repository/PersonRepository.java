package com.example.springdataintroduction.repository;


import com.example.springdataintroduction.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT DISTINCT p FROM Person p LEFT JOIN FETCH p.notes WHERE p.firstName = :firstName")
    List<Person> findAllByFirstNameFetchNotes(@Param("firstName") String firstName);

    @Query("SELECT DISTINCT p FROM Person p LEFT JOIN FETCH p.notes")
    List<Person> findAllBy();
}

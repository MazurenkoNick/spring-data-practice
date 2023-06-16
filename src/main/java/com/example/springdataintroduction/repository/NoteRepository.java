package com.example.springdataintroduction.repository;

import com.example.springdataintroduction.dto.NoteDto;
import com.example.springdataintroduction.entity.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {

    // select new - entities will not be saved to the session, they are just used to map their values to dto
    @Query("SELECT new com.example.springdataintroduction.dto.NoteDto(n.body, p.firstName, p.lastName) " +
            "FROM Note n INNER JOIN n.person p")
    Slice<NoteDto> findAllDtos(Pageable pageable);

    // could have used Page instead of Slice, but additional query would be needed for hibernate to select the count of the all notes
    Slice<NoteDto> findAllBy(Pageable pageable); // IS EQUIVALENT TO THE findAllDtos QUERY METHOD

    <T> Slice<T> findAllBy(Class<T> dtoType, Pageable pageable); // IS EQUIVALENT TO THE findAllDtos and findAllBy, but can be used for different DTO types
}

package com.example.springdataintroduction.controller;

import com.example.springdataintroduction.dto.NoteDto;
import com.example.springdataintroduction.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @GetMapping
    public Slice<NoteDto> getAll(Pageable pageable) {
        // body, author first name, author last name
        return noteService.getAllNotes(NoteDto.class, pageable);
    }
}

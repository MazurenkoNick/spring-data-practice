package com.example.springdataintroduction.service;

import com.example.springdataintroduction.dto.NoteDto;
import com.example.springdataintroduction.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

//    @Transactional(readOnly = true) // will not be updated using dirty check and will not be persisted
    public Slice<NoteDto> getAllNotes(Pageable pageable) {
        return noteRepository.findAllBy(pageable);
    }

    public <T> Slice<T> getAllNotes(Class<T> dtoType, Pageable pageable) {
        return noteRepository.findAllBy(dtoType, pageable);
    }
}

package org.example.springbootnotations.service;

import lombok.RequiredArgsConstructor;
import org.example.springbootnotations.model.Note;
import org.example.springbootnotations.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    private final AtomicLong idGenerator = new AtomicLong(1);



    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    public Note add(Note note) {
        return noteRepository.save(note);
    }

    public void deleteById(long id) {
       noteRepository.deleteById(id);
    }

    public void update(Note note) {
        noteRepository.save(note);
    }

    public Note getById(long id) {
        return noteRepository.findById(id).get();
    }
}

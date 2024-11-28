package org.example.springbootnotations.service;

import lombok.RequiredArgsConstructor;
import org.example.springbootnotations.model.Note;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final Map<Long, Note> notes = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public List<Note> listAll(Note note) {
        return new ArrayList<>(notes.values());
    }

    public Note add(Note note) {
        long id = idGenerator.getAndIncrement();
        note.setId(id);
        notes.put(id, note);
        return note;
    }

    public void deleteById(long id) {
        if (!notes.containsKey(id)) {
            throw new IllegalArgumentException("Note with id " + id + " does not exist");
        }
        notes.remove(id);
    }

    public void update(Note note) {
        if (!notes.containsKey(note.getId())) {
            throw new IllegalArgumentException("Note with id " + note.getId() + " does not exist");
        }
        notes.put(note.getId(), note);
    }

    public Note getById(long id) {
        return Optional.ofNullable(notes.get(id))
                .orElseThrow(() -> new IllegalArgumentException("Note with id " + id + " does not exist"));
    }
}

package org.example.springbootnotations.service;

import lombok.RequiredArgsConstructor;
import org.example.springbootnotations.model.Note;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final Map<Long, Note> notes = new HashMap<>() {{
        put(1L, Note.builder().id(1L).title("Title 1").content("Content for note 1").build());
        put(2L, Note.builder().id(2L).title("Title 2").content("Content for note 2").build());
        put(3L, Note.builder().id(3L).title("Title 3").content("Content for note 3").build());
        put(4L, Note.builder().id(4L).title("Title 4").content("Content for note 4").build());
        put(5L, Note.builder().id(5L).title("Title 5").content("Content for note 5").build());
        put(6L, Note.builder().id(6L).title("Title 6").content("Content for note 6").build());
        put(7L, Note.builder().id(7L).title("Title 7").content("Content for note 7").build());
        put(8L, Note.builder().id(8L).title("Title 8").content("Content for note 8").build());
        put(9L, Note.builder().id(9L).title("Title 9").content("Content for note 9").build());
        put(10L, Note.builder().id(10L).title("Title 10").content("Content for note 10").build());
    }};

    private final AtomicLong idGenerator = new AtomicLong(1);



    public List<Note> listAll() {
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

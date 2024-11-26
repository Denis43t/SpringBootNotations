package org.example.springbootnotations.service;

import lombok.RequiredArgsConstructor;
import org.example.springbootnotations.model.Note;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class NoteService {
    private final SessionFactory sessionFactory;
    public List<Note> listAll(){
        List notes = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            notes = session.createQuery("from Note")
                    .getResultList();
        }
        return notes;
    }
}

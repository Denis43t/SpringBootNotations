package org.example.springbootnotations.repository;

import org.example.springbootnotations.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NoteRepository extends JpaRepository<Note,Long> {
}

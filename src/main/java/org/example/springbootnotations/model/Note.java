package org.example.springbootnotations.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notes")
@Data
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notes_seq")
    @SequenceGenerator(name = "notes_seq", sequenceName = "notes_id_seq", allocationSize = 1)
    private Long id;
    private String title;
    private String content;
}

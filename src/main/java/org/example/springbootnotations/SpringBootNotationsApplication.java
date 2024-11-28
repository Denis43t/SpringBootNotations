package org.example.springbootnotations;

import jakarta.annotation.PostConstruct;
import org.example.springbootnotations.model.Note;
import org.example.springbootnotations.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringBootNotationsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootNotationsApplication.class, args);
    }

}

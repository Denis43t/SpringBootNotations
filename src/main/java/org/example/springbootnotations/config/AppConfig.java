package org.example.springbootnotations.config;

import org.example.springbootnotations.model.Note;
import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class AppConfig {

    @Bean
    public SessionFactory getSessionFactory() {
        return new org.hibernate.cfg.Configuration()
//                .setProperty("hibernate.connection.driver_class","org.postgresql.Driver")
//                .setProperty("hibernate.connection.username","postgres")
//                .setProperty("hibernate.connection.password","password")
//                .setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5492/javas-db")
//                .setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
                .addAnnotatedClass(Note.class)
                .buildSessionFactory();
    }

}

package com.sd4.application;

import com.sd4.model.Author;
import com.sd4.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.sd4.service", "com.sd4.controller"})
@EntityScan("com.sd4.model")
@EnableJpaRepositories("com.sd4.repository")
//@EnableVaadin({"com.sd4.vaadin.views"})

public class SpringBootAndTheCrudRepositoryApplication implements CommandLineRunner {

    @Autowired
    private AuthorRepository authorRepo;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAndTheCrudRepositoryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        authorRepo.save(new Author("Brendan", "Watson", 1949));
        authorRepo.save(new Author("Gerry", "Guinnane", 1939));
        authorRepo.save(new Author("Ita", "Kavanagh", 1965));
    }
}

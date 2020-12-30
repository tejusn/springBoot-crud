package com.crud.springboot;

import com.crud.springboot.model.Student;
import com.crud.springboot.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@Slf4j
public class LoadDatabase {

    private final StudentRepository repo;

    public LoadDatabase(StudentRepository repo) {
        this.repo = repo;
    }

    @PostConstruct
    private void initDatabase(){
        log.info("Pre Loading Database"  + repo.save(new Student("Tejus")));
        log.info("Pre Loading Database"  + repo.save(new Student("Nataraju")));
    }
}

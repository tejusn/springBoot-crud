package com.crud.springboot;

import com.crud.springboot.model.Student;
import com.crud.springboot.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@Slf4j
//refer to the pom.xml for the database dependencies - we have added h2 database which is in-memory
// we want to use an in-memory H2 database in a Spring Boot JPA application, we only need to add the h2 dependency to the pom.xml file:
//This way, we don't need to define the dataSource bean, but we can do so if we want to customize it.

// If we want to use JPA with MySQL database, then we need the mysql-connector-java dependency, as well as to define the DataSource configuration.
// https://www.baeldung.com/the-persistence-layer-with-spring-and-jpa
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

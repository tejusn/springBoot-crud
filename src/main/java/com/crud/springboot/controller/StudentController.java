package com.crud.springboot.controller;

import com.crud.springboot.model.Student;
import com.crud.springboot.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class StudentController {

    //note the fact that this is not a bean and is not autowired. This is just an interface
    private final StudentRepository studentRepository;

    //Constructor injection of the dependancy
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/student")
    private List<Student> all() {
        return studentRepository.findAll();
    }

    @GetMapping("/student/{id}")
    private Optional<Student> one(@PathVariable Long id) {
        return studentRepository.findById(id);
                //.orElseGet(() -> log.debug("FindById failed"));
    }

    @PostMapping("/save")
    private void addOne(@RequestBody Student student){
        log.info("Adding student" + student.getName());
        studentRepository.save(student);
    }

    @PutMapping("/update/{id}")
    private void update(@RequestBody Student newStudent, @PathVariable Long id) {
        studentRepository.findById(id)
                .map(student -> {
                    student.setName(newStudent.getName());
                    return studentRepository.save(student);
                })
                .orElseGet(() -> {
                         newStudent.setId(id);
                         return studentRepository.save(newStudent);
                        });
    }

    @DeleteMapping("/delete/{id}")
    private void deleteRow(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }

}

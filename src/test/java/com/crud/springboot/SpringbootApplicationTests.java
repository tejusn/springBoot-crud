package com.crud.springboot;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers;



//For instance, we can use the @SpringBootTest annotation if we want the entire context to be created without starting the server.
//
//        With that in place, we can then add the @AutoConfigureMockMvc to inject a MockMvc instance and send HTTP requests:
@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class SpringbootApplicationTests {

//    StudentRepository studentRepository;

    @Autowired
    private MockMvc mvc;

    @Test
    void findAllStudents() throws Exception {
       this.mvc.perform(get("/student")
        .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON));

    }

}

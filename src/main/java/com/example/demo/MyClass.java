package com.example.demo;

import com.example.demo.Model.Person;
import com.example.demo.Repo.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyClass{

    @Autowired
    private UserRepo userRepo ;

    @GetMapping
    public List<Person> getall(){
        return userRepo.findAll() ;
    }

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody Person person) {
        Person saved_person = userRepo.save(person);
        return new ResponseEntity<>(saved_person, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    @Transactional
    public Person update(@RequestBody Person person, @PathVariable Long id){
        Person existingUser = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setName(person.getName());
        existingUser.setAge(person.getAge());
        return userRepo.save(existingUser);
    }

    @GetMapping("/greet")
    public String greet(){
        return "hello , this is from the greeting" ;
    }
}

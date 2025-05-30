package com.example.demo.Repo;

import com.example.demo.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Person,Long> {
}
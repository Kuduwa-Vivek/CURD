package com.example.CURD.repository;

import com.example.CURD.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

  Student findByFirstName(String name);
}

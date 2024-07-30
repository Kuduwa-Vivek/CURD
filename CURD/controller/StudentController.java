package com.example.CURD.controller;

import com.example.CURD.entity.Student;
import com.example.CURD.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class StudentController {

  @Autowired
  private StudentService studentService;


  @PostMapping("/add-student")
  public Student addStudent(@RequestBody Student student) {
    return studentService.saveStudent(student);
  }

  @PostMapping("/add-students")
  public List<Student> addStudents(@RequestBody List<Student> students) {
    return studentService.saveAllStudents(students);
  }

  @GetMapping("/all-students")
  public List<Student> allStudents() {
    return studentService.findStudents();
  }

  @GetMapping("/find-by-id/{id}")
  public Student findById(@PathVariable int id) {
    return studentService.findById(id);
  }

  @GetMapping("/find-by-name/{name}")
  public Student findByName(@PathVariable String name) {
    return studentService.findByName(name);
  }

  @DeleteMapping("/delete-by-id/{id}")
  public String deleteById(@PathVariable int id) {
    return studentService.deleteById(id);
  }

  @PutMapping("/update-student")
  public Student updateStudent(@RequestBody Student student) {
    return studentService.updateStudent(student);
  }

}

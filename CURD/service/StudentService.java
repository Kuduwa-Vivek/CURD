package com.example.CURD.service;

import com.example.CURD.entity.Student;
import com.example.CURD.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class StudentService {

  @Autowired
  private StudentRepository studentRepository;

  // Log the student being saved
  public Student saveStudent(@RequestBody Student student) {
    return studentRepository.save(student);
  }

  // Log the list of students being saved
  public List<Student> saveAllStudents(@RequestBody List<Student> students) {
    return studentRepository.saveAll(students);
  }

  // Retrieve and return all students
  public List<Student> findStudents() {
    return studentRepository.findAll();
  }

  // Retrieve and return a student by ID, or null if not found
  public Student findById(int id) {
    return studentRepository.findById(id).orElse(null);
  }

  // Retrieve and return a student by first name
  public Student findByName(String name) {
    return studentRepository.findByFirstName(name);
  }

  // Delete a student by ID and return a success message
  public String deleteById(int id) {
    studentRepository.deleteById(id);
    return "Deleted Successfully" + id;
  }

  // Update an existing student's details and save the changes
  public Student updateStudent(Student student) {
    Student existingStudent = studentRepository.findById(student.getId()).orElse(null);
    existingStudent.setFirstName(student.getFirstName());
    existingStudent.setLastName(student.getLastName());
    existingStudent.setEmailId(student.getEmailId());
    return studentRepository.save(existingStudent);
  }


}

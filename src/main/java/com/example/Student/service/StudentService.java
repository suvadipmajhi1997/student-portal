package com.example.Student.service;

import com.example.Student.model.Student;
import com.example.Student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public String insertStudentList(List<Student> studentList) {
        Iterable<Student> students=studentRepository.saveAll(studentList);
        return "student list added";
    }

    public List<Student> get() {
        return (List<Student>)studentRepository.findAll();
    }


    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }


    public void removeStudentById(long id) {
        studentRepository.deleteById(id);
    }
}

package com.example.Student.controller;

import com.example.Student.model.Student;
import com.example.Student.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping(value = "/addStudents")
    public ResponseEntity<Student> insert(@Valid @RequestBody Student student) {
        Student obj = studentService.addStudent(student);
        return new ResponseEntity<>(obj, HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/addList")
    public String addStudentList(@Valid @RequestBody List<Student> studentList) {
        return studentService.insertStudentList(studentList);
    }

    @GetMapping(value = "/getList")
    public ResponseEntity<List<Student>> getStudentList() {
        List<Student> students = studentService.get();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Student> getStudentDetails(@PathVariable Long id) {
        Optional<Student> student = (studentService.getStudentById(id));
        return student.map(value -> new ResponseEntity<>(value, HttpStatus.FOUND))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Student> updateDetails(@PathVariable long id, @RequestBody @Valid Student student) {
        Optional<Student> existing = studentService.getStudentById(id);
        if (existing.isPresent()) {
            student.setStudentId(id);
            Student update = studentService.updateStudent(student);
            return new ResponseEntity<>(update,HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

   @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> removeStudent(@PathVariable long id){
        Optional<Student>exitingStudent=studentService.getStudentById(id);
        if(exitingStudent.isPresent()){
            studentService.removeStudentById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }
}
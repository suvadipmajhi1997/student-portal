package com.example.Student.repository;
import com.example.Student.model.Department;
import com.example.Student.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {
    List<Student> findByUserName(String userName);
    List<Student>getByDepartment(Department department);
    List<Student> findByFirstNameAndDepartment(String firstName, Department department);

}

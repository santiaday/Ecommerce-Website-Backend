package com.test.ecommercesystem.service;

import com.test.ecommercesystem.model.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);

    public List<Student> getAllStudents();

}

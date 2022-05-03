package com.test.ecommercesystem.service;


import org.springframework.beans.factory.annotation.Autowired;
import com.test.ecommercesystem.repository.StudentRepo;
import com.test.ecommercesystem.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImplementation implements StudentService{

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }
}

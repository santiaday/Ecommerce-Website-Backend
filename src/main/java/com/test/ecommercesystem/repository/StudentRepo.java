package com.test.ecommercesystem.repository;

import com.test.ecommercesystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface StudentRepo extends JpaRepository<Student, Integer> {
}

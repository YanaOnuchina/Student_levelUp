package com.github.daniilandco.studentstorageservice.repository;

import com.github.daniilandco.studentstorageservice.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
    boolean existsByStudentId(Long studentId);
}

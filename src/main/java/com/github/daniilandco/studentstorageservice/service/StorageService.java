package com.github.daniilandco.studentstorageservice.service;

import com.github.daniilandco.studentstorageservice.entity.Student;
import com.github.daniilandco.studentstorageservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStorage() {
        return (List<Student>) studentRepository.findAll();
    }

    public boolean add(Student student) {
        if (studentRepository.existsByStudentId(student.getStudentId())) {
            return false;
        } else {
            studentRepository.save(student);
            return true;
        }
    }
}

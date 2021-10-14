package com.github.daniilandco.studentstorageservice.service;

import com.github.daniilandco.studentstorageservice.entity.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StorageService {
    private List<Student> storage = new ArrayList<Student>();

    public List<Student> getStorage() {
        return storage;
    }

    public void add(Student student) throws Exception {
        if (storage.stream().anyMatch(currentStudent -> currentStudent.getStudentId().equals(student.getStudentId()))) {
            throw new Exception("Student id already exists");
        }
        storage.add(student);
    }
}

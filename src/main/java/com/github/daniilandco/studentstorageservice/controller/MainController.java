package com.github.daniilandco.studentstorageservice.controller;

import com.github.daniilandco.studentstorageservice.entity.Student;
import com.github.daniilandco.studentstorageservice.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private StorageService storageService;

    @GetMapping("/")
    public String main() {
        return "Hello, LevelUp";
    }

    @GetMapping("/{name}")
    public String hello(@PathVariable String name) {
        return "Hello, " + name;
    }

    @PostMapping("/add")
    public String addNewStudent(@RequestBody Student student) {
        try {
            storageService.add(student);
            return "New student has been added";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    @GetMapping("/storage")
    public List<Student> storage() {
        return storageService.getStorage();
    }

}

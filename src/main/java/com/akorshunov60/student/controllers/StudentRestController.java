package com.akorshunov60.student.controllers;

import com.akorshunov60.student.models.Student;
import com.akorshunov60.student.servises.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentRestController {

    private final StudentService service;

    @GetMapping("/all")
    public List<Student> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}/id")
    public Student findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}/id")
    public void delete(@PathVariable("id") Long id) {
        service.deleteById(id);
    }

    @PostMapping()
    public Student create(@RequestBody Student student) {
        return service.create(student);
    }

    @PutMapping()
    public Student update(@RequestBody Student student) {
        return service.update(student);
    }
}

package com.akorshunov60.student.servises;

import com.akorshunov60.student.exceptions.BadRequestException;
import com.akorshunov60.student.exceptions.ResourceNotFoundException;
import com.akorshunov60.student.models.Student;
import com.akorshunov60.student.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository repository;

    public List<Student> findAll() {
        return repository.findAll();
    }

    public Student findById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Student id: " + id + " not found"
                        ));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Student create(Student student) {
        if (student.getId() != null ) {
            throw new BadRequestException();
        }
        return repository.save(student);
    }

    public Student update(Student student) {
        if (student.getId() == null) {
            throw new BadRequestException();
        }
        return repository.save(student);
    }
}

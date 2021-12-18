package com.akorshunov60.student.repositories;

import com.akorshunov60.student.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

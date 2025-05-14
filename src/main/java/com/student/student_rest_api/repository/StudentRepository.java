package com.student.student_rest_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.student_rest_api.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

	boolean existsByMobile(Long mobile);

	Student save(List<Student> students);

}

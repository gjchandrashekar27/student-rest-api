package com.student.student_rest_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.student_rest_api.dto.StudentDto;
import com.student.student_rest_api.entity.Student;
import com.student.student_rest_api.service.StudentService;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	
	//Send  Only One Student Details At a time.
	@PostMapping("/student")
	public ResponseEntity<Student>saveStudent(@RequestBody StudentDto dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.saveStudent(dto));
	}
	
	//Send Multiple Students Record At A time.
	@PostMapping("/students")
	public ResponseEntity<Object> saveStudents(@RequestBody List<StudentDto> dto){
		return ResponseEntity.status(HttpStatus.OK).body(studentService.saveStudents(dto));
	}
	
	//Fetch All The Records.
	@GetMapping("/students")
	public ResponseEntity<List<Student>> fetchStudents(
			@RequestParam(defaultValue = "id") String sort,
			@RequestParam(defaultValue = "false") boolean desc,
			@RequestParam(defaultValue = "1")int page,
			@RequestParam(defaultValue = "5") int data)
	{
		return ResponseEntity.status(HttpStatus.OK).body(studentService.fetchAll(sort,desc,page,data));
	}
	
	//Edit The Student Record Based Id.
	@PutMapping("/student/{id}")
	public ResponseEntity<Object> editById(@PathVariable Long id,@RequestBody StudentDto dto){
		return ResponseEntity.status(HttpStatus.OK).body(studentService.editById(dto,id));
	}
	
	//Delete The Student Record Based On Id
	@DeleteMapping("/student/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(studentService.deleteById(id));
	}
	
	
	
	

}

package com.student.student_rest_api.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import com.student.student_rest_api.dto.StudentDto;
import com.student.student_rest_api.entity.Student;
import com.student.student_rest_api.exception.DataAlreadyExistsException;
import com.student.student_rest_api.exception.DataNotFoundException;
import com.student.student_rest_api.repository.StudentRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;

    //Saving logic of Single Student at a Time.
	public Student saveStudent(StudentDto dto) {
		if(!studentRepository.existsByMobile(dto.getMobile())) {
			Student student = new Student(dto);
			studentRepository.save(student);
			return student;
		}else {
			throw new DataAlreadyExistsException("Mobile Number Already Exists:"+dto.getMobile());
			
		}
		
		
	}

    //Saving The Logic Multiple Students At a Time.
	public Object saveStudents(List<StudentDto> dto) {
		List<Student>students = new ArrayList<Student>();
		for (StudentDto studentDto : dto) {
			if(studentRepository.existsByMobile(studentDto.getMobile()))
				throw new DataAlreadyExistsException("Mobile Number Alredy Exists:"+ studentDto.getMobile());
			else
				students.add(new Student(studentDto));	
		}
		return studentRepository.saveAll(students);
		
	}

	
    //Fetch All The Records From DataBase and Sort By Descending Order And Pagination also done.
	public List<Student> fetchAll(String sort, boolean desc, int page, int size) {
	    Sort sortBy = Sort.by(sort);
	    if (desc) {
	        sortBy = sortBy.descending();
	    }

	    Pageable pageable = PageRequest.of(page - 1, size, sortBy);
	    Page<Student> records = studentRepository.findAll(pageable);

	    if (!records.isEmpty()) {
	        return records.getContent();
	    } else {
	        throw new DataNotFoundException("No student records found");
	    }
	}

 		
	}



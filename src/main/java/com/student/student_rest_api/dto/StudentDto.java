package com.student.student_rest_api.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentDto {

    private String name;
	
	private Long mobile;
	
	private Integer maths;
	
	private Integer science;
	
	private Integer english;

}

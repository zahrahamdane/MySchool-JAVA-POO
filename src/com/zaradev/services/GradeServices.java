package com.zaradev.services;

import com.zaradev.models.Grade;
import com.zaradev.models.Student;

public class GradeServices {

	Grade grade;

	public void addStudent(Student student) {
		this.grade.getStudents().add(student);
	}
	
	public void removeStudent(Student student) {
		this.grade.getStudents().remove(student);
	}

}

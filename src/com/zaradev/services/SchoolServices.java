package com.zaradev.services;

import com.zaradev.models.Grade;
import com.zaradev.models.School;
import com.zaradev.models.Student;
import com.zaradev.models.Teacher;

public class SchoolServices {

	School school;

	public SchoolServices(School school) {
		this.school = school;
	}

	public School getSchool() {
		return school;
	}

	public void addStudent(Student student) {
		this.school.getStudents().add(student);
	}

	public void addTeacher(Teacher teacher) {
		this.school.getTeatchers().add(teacher);
	}

	public void addGrade(Grade grade) {
		this.school.getGrades().add(grade);
	}

	public void removeStudent(Student student) {
		this.school.getStudents().remove(student);
	}

	public void removeTeacher(Teacher teacher) {
		this.school.getTeatchers().remove(teacher);
	}

	public void removeGrade(Grade grade) {
		this.school.getGrades().remove(grade);
	}

	public Student getStudentByName(String name) {
		Student s = null;
		for (Student student : this.school.getStudents()) {
			if (student.getName().toUpperCase().equals(name.toUpperCase())) {
				s = student;
				break;
			}
		}
		return s;
	}

	public Teacher getTeacherByName(String name) {
		Teacher t = null;
		for (Teacher teacher : this.school.getTeatchers()) {
			if (teacher.getName().toUpperCase().equals(name.toUpperCase())) {
				t = teacher;
				break;
			}
		}
		return t;
	}

	public Grade getGradeByCode(String code) {
		Grade g = null;
		for (Grade grade : this.school.getGrades()) {
			if (grade.getCode().equals(code)) {
				g = grade;
			}
		}
		return g;
	}
}

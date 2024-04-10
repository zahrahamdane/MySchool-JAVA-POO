package com.zaradev.main;

import java.util.Scanner;

import com.zaradev.models.Person;
import com.zaradev.models.School;
import com.zaradev.models.Student;
import com.zaradev.models.Teacher;
import com.zaradev.services.SchoolServices;
import com.zaradev.tools.Actions;

public class Hmi {

	private static SchoolServices schoolServices;

	public static void start() {

		Scanner scanner = new Scanner(System.in);
		School school = Hmi.createSchool();

		System.out.println("Welcom to " + school.getName() + " in " + school.getAddress());
		String action;

		do {
			System.out.println("What do you want to do ? ");
			action = scanner.next();

			switch (action) {
			case "addStudent":
				Hmi.addStudent();
				break;
			case "addTeacher":
				Hmi.addTeacher();
				break;
			case "printAllStudents":
				Hmi.printAllStudents();
				break;
			case "printAllTeachers":
				Hmi.printAllTeachers();
				break;
			case "findStudentByName":
				printDataPersonByName(Actions.STUDENT);
				break;
			case "findTeacherByName":
				printDataPersonByName(Actions.TEACHER);
				break;
			case "removeStudent":
				Hmi.removePerson(Actions.STUDENT);
				break;
			case "removeTeacher":
				Hmi.removePerson(Actions.TEACHER);
				break;
			}		

		} while (!action.equals("exit"));
	}

	private static School createSchool() {
		School school = new School();
		school.setName("School online");
		school.setAddress("Morocco");
		school.setPhoneNumber("0505060758");
		Hmi.schoolServices = new SchoolServices(school);
		return school;
	}

	private static void addStudent() {
		Student student = new Student();
		Hmi.setDataPerson(student);
		Hmi.schoolServices.addStudent(student);
	}

	private static void addTeacher() {
		Teacher teacher = new Teacher();
		Hmi.setDataPerson(teacher);
		Hmi.schoolServices.addTeacher(teacher);
	}

	private static void printAllStudents() {
		for (Student student : Hmi.schoolServices.getSchool().getStudents()) {
			System.out.println(student.getData());
		}
	}

	private static void printAllTeachers() {
		for (Teacher teacher : Hmi.schoolServices.getSchool().getTeatchers()) {
			System.out.println(teacher.getData());
		}
	}

	private static void setDataPerson(Person p) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Please enter the name");
		p.setName(reader.next());
		System.out.println("Please enter the age");
		p.setAge(reader.nextInt());

		if (p instanceof Student) {
			System.out.println("Please enter the parent phone number");
			((Student) p).setParentPhoneNumber(reader.next());
		} else if (p instanceof Teacher) {
			System.out.println("Please enter the salary");
			((Teacher) p).setSalary(reader.nextFloat());
		}

	}

	private static void printDataPerson(Person person) {
		if (person == null) {
			System.out.println("Not found !!!");
		} else {
			System.out.println(person.getData());
		}
	}

	private static Person findPersonByName(Actions action) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Please entre the name");
		String name = reader.next();
		Person p = null;
		if (action == Actions.STUDENT) {
			p = Hmi.schoolServices.getStudentByName(name);
		} else if (action == Actions.TEACHER) {
			p = Hmi.schoolServices.getTeacherByName(name);
		}
		return p;
	}
	
	private static void printDataPersonByName(Actions action) {
		Person p = findPersonByName(action);
		printDataPerson(p)
	}

	private static void removePerson(Actions action) {
		Person p = Hmi.findPersonByName(action);
		if (p instanceof Student) {
			Hmi.schoolServices.removeStudent((Student) p);
		} else {
			Hmi.schoolServices.removeTeacher((Teacher) p);
		}

	}

}

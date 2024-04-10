package com.zaradev.models;

public class Student extends Person {
	String ParentPhoneNumber;

	public Student() {
		super();
	}

	public Student(String parentPhoneNumber) {
		super();
		ParentPhoneNumber = parentPhoneNumber;
	}

	public String getParentPhoneNumber() {
		return ParentPhoneNumber;
	}

	public void setParentPhoneNumber(String parentPhoneNumber) {
		ParentPhoneNumber = parentPhoneNumber;
	}

	@Override
	public String getData() {
		return this.getName() + ", " + this.getAge() + "ans, " + this.getParentPhoneNumber();
	}

}

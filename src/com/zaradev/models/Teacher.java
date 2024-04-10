package com.zaradev.models;

public class Teacher extends Person {
	float salary;

	public Teacher() {
		super();
	}

	public Teacher(float salary) {
		super();
		this.salary = salary;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	@Override
	public String getData() {
		return this.getName() + ", " + this.getAge() + "ans, " + this.getSalary();
	}

}

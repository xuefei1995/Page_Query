package com.xuefei.entity;

public class Student {
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", gender=" + gender
				+ ", servlet=" + servlet + ", java=" + java + "]";
	}
	private String name;
	private int age;
	private String gender;
	private int servlet;
	private int java;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getServlet() {
		return servlet;
	}
	public void setServlet(int servlet) {
		this.servlet = servlet;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	
}

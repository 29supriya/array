package com.mindtree.Students.vo;

import com.mindtree.Students.Entity.Students;

public class ResponseTemplate {

	private Students student;
	private Colleges college;
	public Students getStudent() {
		return student;
	}
	public void setStudent(Students student) {
		this.student = student;
	}
	public Colleges getCollege() {
		return college;
	}
	public void setCollege(Colleges college) {
		this.college = college;
	}
	public ResponseTemplate(Students student, Colleges college) {
		super();
		this.student = student;
		this.college = college;
	}
	public ResponseTemplate() {
		super();
		
	
}
}



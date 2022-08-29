package com.mindtree.Students.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Students {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	private int rollNo;
	private String sname;
	private int age;
	private String gender;
	private String stream;
	private int clgId;
	public Students(int rollNo, String sname, int age, String gender, String stream, int clgId) {
		super();
		this.rollNo = rollNo;
		this.sname = sname;
		this.age = age;
		this.gender = gender;
		this.stream = stream;
		this.clgId = clgId;
	}
	public Students() {
		super();
		
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
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
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public int getClgId() {
		return clgId;
	}
	public void setClgId(int clgId) {
		this.clgId = clgId;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", sname=" + sname + ", age=" + age + ", gender=" + gender + ", stream="
				+ stream + ", clgId=" + clgId + "]";
	}
	
	
}
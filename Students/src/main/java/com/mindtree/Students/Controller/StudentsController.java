package com.mindtree.Students.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.Students.Entity.Students;
import com.mindtree.Students.Service.StudentsService;

@RestController
@RequestMapping("/students")
public class StudentsController {
	
	@Autowired
	private StudentsService studServ;
	
	@PostMapping
	public Students add(@RequestBody Students s) {
		return studServ.addStudent(s);
	}
	
	@GetMapping
	public List<Students> getAll(){
		return studServ.getAllStudents();
	}
	
	@GetMapping("/{rollNo}")
	public Students getStudent(@PathVariable int rollNo) {
		return studServ.getStudents(rollNo);
	}

	@PutMapping("/{rollNo}/{clgId}")
	public String updateCollege(@PathVariable int rollNo,@PathVariable int clgId) {
		Students s=studServ.assignColleges(rollNo, clgId);
		if(s!=null) {
			return s.toString();
		}
		return "not found";
	}
	
	@GetMapping("/student-with-ascname/{clgId}")
	public List<Students> getByClgId(@PathVariable int clgId){
		return studServ.getByCollegeId(clgId);
	}
	
	@GetMapping("/student-with-desc-age/{clgId}")
	public List<Students> getStudentByCollegeWithDescAge(@PathVariable int clgId){
		return studServ.getStudentByCollegeWithDescAge(clgId);
	}
}



	

	



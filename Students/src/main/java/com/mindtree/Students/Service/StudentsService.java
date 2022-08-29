package com.mindtree.Students.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mindtree.Students.Entity.Students;
import com.mindtree.Students.Repository.StudentsRepository;
import com.mindtree.Students.vo.Colleges;
import com.mindtree.Students.vo.ResponseTemplate;

@Service
public class StudentsService {

	@Autowired
	private StudentsRepository studrepo;
	@Autowired
	private RestTemplate restTemp;
	
	public Students addStudent(Students s) {
		return studrepo.save(s);
	}
	public List<Students> getAllStudents(){
		return studrepo.findAll();
	}
	public Students getStudents(int rollNo) {
		return studrepo.findById(rollNo).get();
	}
	
	public ResponseTemplate studWithCollege(int rollNo) {
		ResponseTemplate rt=new ResponseTemplate();
		Students s=studrepo.findById(rollNo).get();
		Colleges c=restTemp.getForObject("http://COLLEGES-SERVICE/colleges/"+s.getClgId(),Colleges.class);
		rt.setCollege(c);
		rt.setStudent(s);
	      return rt;
	}
	public Students assignColleges(int rollNo,int clgId) {
		Students s=studrepo.findById(rollNo).get();
		Colleges c=restTemp.getForObject("http://COLLEGES-SERVICE/colleges/"+clgId,Colleges.class);
        if(s==null || c==null) {
        	return null;
        }
        s.setClgId(clgId);
        studrepo.save(s);
        return s;
	}
	public List<Students> getByCollegeId(int clgId){
		return studrepo.getCollegesId(clgId);
	}
	public List<Students> getStudentByCollegeWithDescAge(int clgId){
		return studrepo.getByCollegesWithDescAge(clgId);
	}
}



	



package com.mindtree.Students.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mindtree.Students.Entity.Students;

@Repository
public interface StudentsRepository extends JpaRepository<Students , Integer>{
	@Query(value="SELECT * FROM students WHERE clg_id=:clgId ORDER BY sname ASC",nativeQuery=true)
	List<Students> getCollegesId(@Param("clgId")int clgId);
	@Query(value="SELECT * FROM students WHERE clg_id=:clgId ORDER BY age DESC",nativeQuery=true)
	List<Students> getByCollegesWithDescAge(@Param("clgId") int clgId);
	


}

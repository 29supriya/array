package com.mindtree.Students;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mindtree.Students.Entity.Students;
import com.mindtree.Students.Repository.StudentsRepository;
import com.mindtree.Students.Service.StudentsService;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class StudentsApplicationTests {
	@Autowired
	private StudentsService service;
	@MockBean
	private StudentsRepository repository;
	@BeforeEach
	void setUp() {
		repository.deleteAll();
	}

	@Test
	public void GetAllStudentTest() {
		when(repository.findAll()).thenReturn(
				Stream.of(new Students(),new Students()).collect(
				Collectors.toList()));
				assertEquals(2,service.getAllStudents().size());
		
	}
	}


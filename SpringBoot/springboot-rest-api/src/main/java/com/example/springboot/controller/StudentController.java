package com.example.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.bean.Student;

@RestController
@RequestMapping("/students")
public class StudentController {
	@GetMapping("/student")
	public ResponseEntity<Student> getStudent() {
		Student student = new Student();

		student.setId(1);
		student.setFirstName("Sindhu");
		student.setLastName("kona");

		return new ResponseEntity<Student>(student, HttpStatus.OK);

	}

	@GetMapping()
	public ResponseEntity<List<Student>> getAllStudents() {

		List<Student> student = new ArrayList<Student>();
		student.add(new Student(1, "sinhdu", "kona"));
		student.add(new Student(2, "priya", "kona"));

		return ResponseEntity.ok(student);

	}

//{id}-ui template variable
	@GetMapping("{id}/{first-name}/{last-name}")
	public ResponseEntity<Student> StudentPathVaraibale(@PathVariable("id") int studentId,
			@PathVariable("first-name") String firstName, @PathVariable("last-name") String lastName) {

		Student student = new Student(studentId, firstName, lastName);
		return ResponseEntity.ok(student);

	}

	@GetMapping("query")
	public ResponseEntity<Student> StudentRequestVariable(@RequestParam int id, @RequestParam String firstName,
			@RequestParam String lastName) {
		Student student = new Student(id, firstName, lastName);
		return ResponseEntity.ok(student);
	}

	@PostMapping("create")
	// @ReponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		System.out.println(student.getId());
		System.out.println(student.getLastName());
		System.out.println(student.getFirstName());

		return new ResponseEntity<Student>(student, HttpStatus.CREATED);

	}

	@PutMapping("{id}/update")
	public ResponseEntity<Student> updateStudentById(@PathVariable("id") int StudentId, @RequestBody Student student) {
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return ResponseEntity.ok(student);

	}

	@DeleteMapping("{id}/delete")
	public ResponseEntity<String> deleteStudentById(@PathVariable("id") int StudentId) {
		System.out.println(StudentId);
		return ResponseEntity.ok("Student Deleted Successfully");

	}
}

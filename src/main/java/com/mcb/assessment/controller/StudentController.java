package com.mcb.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcb.assessment.entity.Group;
import com.mcb.assessment.entity.Marks;
import com.mcb.assessment.entity.Student;
import com.mcb.assessment.entity.Subject;
import com.mcb.assessment.entity.SubjectTeacher;
import com.mcb.assessment.service.StudentService;

@RestController
@RequestMapping(value = "")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/totalMarks/{studentId}")	
	public ResponseEntity<Long> getMarksByStudentId(@PathVariable long studentId) {
		Long marks= studentService.getMarksByStudentId(studentId);
		
		return new ResponseEntity<Long>(marks,HttpStatus.OK);
	}
	@GetMapping("/studentcount/{id}")	
	public ResponseEntity<Long> getNumberOfStudentForTeacherId(@PathVariable long id) {
		
		Long count=studentService.getNumberOfStudentForTeacherId(id);
		
		return new ResponseEntity<Long>(count,HttpStatus.OK);
	}
	@GetMapping("/liststudentmarks/{id}")	
	public ResponseEntity<List<Marks>> getListOfMarksByStudentId(@PathVariable long id) {
		
		
		List<Marks> marksList=studentService.getListOfMarksByStudentId(id);
		
		return new ResponseEntity<List<Marks>>(marksList,HttpStatus.OK);
	}
	
	@PostMapping("/marks")	
	public ResponseEntity<Marks> addMarks(@RequestBody Marks mark) {
		Marks marks= studentService.addMarks(mark);
		
		return new ResponseEntity<Marks>(marks,HttpStatus.OK);
	}
	
	@PutMapping("/marks")	
	public ResponseEntity<Marks> updateMarks(@RequestBody Marks mark) {
		Marks marks= studentService.updateMarks(mark);
		
		return new ResponseEntity<Marks>(marks,HttpStatus.OK);
	}
	
	@GetMapping("/marks")	
	public ResponseEntity<List<Marks>> getAllMarks() {
		List<Marks> marks= studentService.getAllMarks();
		
		return new ResponseEntity<List<Marks>>(marks,HttpStatus.OK);
	}
	
	
	
	@PostMapping("/student")	
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		Student updatedstudent= studentService.addStudent(student);
		
		return new ResponseEntity<Student>(updatedstudent,HttpStatus.OK);
	}
	
	@PutMapping("/student")	
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		Student updatedstudent= studentService.updateStudent(student);
		
		return new ResponseEntity<Student>(updatedstudent,HttpStatus.OK);
	}
	@GetMapping("/student")	
	public ResponseEntity<List<Student>> getAllStudent() {
		List<Student> student= studentService.getAllStudent();
		
		return new ResponseEntity<List<Student>>(student,HttpStatus.OK);
	}
	@DeleteMapping("/student/{id}")	
	public ResponseEntity<String> deleteStudent(@PathVariable long id) {
		studentService.deleteStudent(id);
		
		return new ResponseEntity<String>("Deleted!",HttpStatus.OK);
	}
	@GetMapping("/student/{id}")	
	public ResponseEntity<List<Student>> findStudent(@PathVariable long id) {
		List<Student> list=studentService.findStudent(id);
		
		return new ResponseEntity<List<Student>>(list,HttpStatus.OK);
	}
	
	@PostMapping("/subject")	
	public ResponseEntity<Subject> addSubject(@RequestBody Subject subject) {
		Subject updatedSubject= studentService.addSubject(subject);
		
		return new ResponseEntity<Subject>(updatedSubject,HttpStatus.OK);
	}
	
	@PutMapping("/subject")	
	public ResponseEntity<Subject> updateSubject(@RequestBody Subject subject) {
		Subject updatedSubject= studentService.updateSubject(subject);
		
		return new ResponseEntity<Subject>(updatedSubject,HttpStatus.OK);
	}
	@GetMapping("/subject")	
	public ResponseEntity<List<Subject>> getAllSubject() {
		List<Subject> subject= studentService.getAllSubject();
		
		return new ResponseEntity<List<Subject>>(subject,HttpStatus.OK);
	}
	
	@PostMapping("/subjectteacher")	
	public ResponseEntity<SubjectTeacher> addsubjectTeacher(@RequestBody SubjectTeacher subjectTeacher) {
		SubjectTeacher updatedSubjectTeacher= studentService.addSubjectTeacher(subjectTeacher);
		
		return new ResponseEntity<SubjectTeacher>(updatedSubjectTeacher,HttpStatus.OK);
	}
	
	@PutMapping("/subjectTeacher")	
	public ResponseEntity<SubjectTeacher> updatesubjectTeacher(@RequestBody SubjectTeacher subjectTeacher) {
		SubjectTeacher updatedSubjectTeacher= studentService.updateSubjectTeacher(subjectTeacher);
		
		return new ResponseEntity<SubjectTeacher>(updatedSubjectTeacher,HttpStatus.OK);
	}
	@GetMapping("/subjectTeacher")	
	public ResponseEntity<List<SubjectTeacher>> getAllsubjectTeacher() {
		List<SubjectTeacher> subject= studentService.getAllSubjectTeacher();
		
		return new ResponseEntity<List<SubjectTeacher>>(subject,HttpStatus.OK);
	}
	@DeleteMapping("/subjectTeacher/{teacherId}/{subjectId}")	
	public ResponseEntity<String> deletesubjectTeacher(@PathVariable long teacherId,@PathVariable long subjectId) {
		studentService.deleteSubjectTeacher(teacherId,subjectId);
		
		return new ResponseEntity<String>("Deleted!",HttpStatus.OK);
	}
	@GetMapping("/subjectTeacher/{id}")	
	public ResponseEntity<List<SubjectTeacher>> findsubjectTeacher(@PathVariable long id) {
		List<SubjectTeacher> list=studentService.findsubjectTeacher(id);
		
		return new ResponseEntity<List<SubjectTeacher>>(list,HttpStatus.OK);
	}
	
	@PostMapping("/group")	
	public ResponseEntity<Group> addGroup(@RequestBody Group group) {
		Group updatedGroup= studentService.addGroup(group);
		
		return new ResponseEntity<Group>(updatedGroup,HttpStatus.OK);
	}
	
	@PutMapping("/group")	
	public ResponseEntity<Group> updateGroup(@RequestBody Group group) {
		Group updatedGroup= studentService.updateGroup(group);
		
		return new ResponseEntity<Group>(updatedGroup,HttpStatus.OK);
	}
	@GetMapping("/group")	
	public ResponseEntity<List<Group>> getAllGroup() {
		List<Group> grp= studentService.getAllGroup();
		
		return new ResponseEntity<List<Group>>(grp,HttpStatus.OK);
	}
	@DeleteMapping("/group/{id}")	
	public ResponseEntity<String> deleteGroup(@PathVariable long id) {
		studentService.deleteGroup(id);
		
		return new ResponseEntity<String>("Deleted!",HttpStatus.OK);
	}
	@GetMapping("/group/{id}")	
	public ResponseEntity<List<Group>> findGroup(@PathVariable long id) {
		List<Group> list=studentService.findGroup(id);
		
		return new ResponseEntity<List<Group>>(list,HttpStatus.OK);
	}

}

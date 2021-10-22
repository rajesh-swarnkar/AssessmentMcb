package com.mcb.assessment.service;

import java.util.List;

import com.mcb.assessment.entity.Group;
import com.mcb.assessment.entity.Marks;
import com.mcb.assessment.entity.Student;
import com.mcb.assessment.entity.Subject;
import com.mcb.assessment.entity.SubjectTeacher;

public interface StudentService {
	
	public Long getMarksByStudentId(Long id);
	
	public Long getNumberOfStudentForTeacherId(Long id);
	
	public List<Marks> getListOfMarksByStudentId(Long id);

	public Marks addMarks(Marks mark);

	public Marks updateMarks(Marks mark);

	public List<Marks> getAllMarks();

	public Student addStudent(Student student);

	public Student updateStudent(Student student);

	public List<Student> getAllStudent();

	public Subject addSubject(Subject subject);

	public Subject updateSubject(Subject subject);

	public List<Subject> getAllSubject();

	public SubjectTeacher addSubjectTeacher(SubjectTeacher subjectTeacher);

	public SubjectTeacher updateSubjectTeacher(SubjectTeacher subjectTeacher);

	public List<SubjectTeacher> getAllSubjectTeacher();

	public void deleteSubjectTeacher(long teacherId,long studentId);

	public List<SubjectTeacher> findsubjectTeacher(long id);

	public Group updateGroup(Group group);

	public List<Group> getAllGroup();

	public Group addGroup(Group group);

	public void deleteGroup(long id);

	public List<Group> findGroup(long id);

	public void deleteStudent(long id);

	public List<Student> findStudent(long id);

}

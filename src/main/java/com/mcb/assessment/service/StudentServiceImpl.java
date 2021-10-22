package com.mcb.assessment.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mcb.assessment.entity.Group;
import com.mcb.assessment.entity.Marks;
import com.mcb.assessment.entity.Student;
import com.mcb.assessment.entity.Subject;
import com.mcb.assessment.entity.SubjectTeacher;
import com.mcb.assessment.repository.GroupRepository;
import com.mcb.assessment.repository.MarksRepository;
import com.mcb.assessment.repository.StudentRepository;
import com.mcb.assessment.repository.SubjectRepository;
import com.mcb.assessment.repository.SubjectTeacherRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private MarksRepository marksRepository;
	
	@Autowired
	private SubjectTeacherRepository subjectTeacherRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private GroupRepository groupRepository;
	
	@Autowired
	private SubjectRepository subjectRepository;

	@Override
	public Long getMarksByStudentId(Long id) {
		Long marks= marksRepository.findByStudentId(id);
		return marks;
	}

	@Override
	public Long getNumberOfStudentForTeacherId(Long id) {
		
		//1.fetch list of group id from subjectTeacher
		List<SubjectTeacher> subjectTeachers=subjectTeacherRepository.findAllByIdTeacherId(id);
		
		List<Long> groups=new ArrayList<>();
		if(subjectTeachers!=null && subjectTeachers.size()>0) {
			groups=subjectTeachers.stream().map(s->s.getGroup_id()).collect(Collectors.toList());
		}
		//2. fetch all student belongs to group id
		List<Student> studentList=studentRepository.findAllByGroupIdIn(groups);
		
		Long count=studentList.stream().count();
		
		return count;
	}

	@Override
	public List<Marks> getListOfMarksByStudentId(Long id) {
		List<Marks> marksList=marksRepository.getListOfMarksInEachSubjectForStudent(id);
		return marksList;
	}

	@Override
	public Marks addMarks(Marks mark) {
		
		Marks marks=marksRepository.save(mark);
		return marks;
	}

	@Override
	public Marks updateMarks(Marks mark) {
		marksRepository.saveOrUpdate(mark.getMarkId(),mark.getMarks());
		return mark;
	}

	@Override
	public List<Marks> getAllMarks() {
		
		return marksRepository.findAll();
	}

	@Override
	public Student addStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Student student) {
		studentRepository.saveOrUpdate(student.getStudentId(),student.getGroupId());
		return student;
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Subject addSubject(Subject subject) {
		// TODO Auto-generated method stub
		return subjectRepository.save(subject);
	}

	@Override
	public Subject updateSubject(Subject subject) {
		// TODO Auto-generated method stub
		subjectRepository.saveOrUpdate(subject.getSubjectId(),subject.getTitle());
		return subject;
	}

	@Override
	public List<Subject> getAllSubject() {
		// TODO Auto-generated method stub
		return subjectRepository.findAll();
	}

	@Override
	public SubjectTeacher addSubjectTeacher(SubjectTeacher subjectTeacher) {
		// TODO Auto-generated method stub
		return subjectTeacherRepository.save(subjectTeacher);
	}

	@Override
	public SubjectTeacher updateSubjectTeacher(SubjectTeacher subjectTeacher) {
		// TODO Auto-generated method stub
		subjectTeacherRepository.saveOrUpdate(subjectTeacher.getId().getSubjectId(),subjectTeacher.getId().getTeacherId(),subjectTeacher.getGroup_id());
		return subjectTeacher;
	}

	@Override
	public List<SubjectTeacher> getAllSubjectTeacher() {
		// TODO Auto-generated method stub
		return subjectTeacherRepository.findAll();
	}

	@Override
	public void deleteSubjectTeacher(long teacherId,long studentId) {
		subjectTeacherRepository.deleteSubjectTeacher(teacherId,studentId);
		
	}

	@Override
	public List<SubjectTeacher> findsubjectTeacher(long id) {
		// TODO Auto-generated method stub
		return subjectTeacherRepository.findAllByIdTeacherId(id);
	}

	@Override
	public Group updateGroup(Group group) {
		groupRepository.saveOrUpdate(group.getGroupId(),group.getName());
		return group;
	}

	@Override
	public List<Group> getAllGroup() {
		// TODO Auto-generated method stub
		return groupRepository.findAll();
	}

	@Override
	public Group addGroup(Group group) {
		// TODO Auto-generated method stub
		System.out.println(group.getGroupId()+": "+group.getName());
		return groupRepository.save(group);
	}

	@Override
	public void deleteGroup(long id) {
		// TODO Auto-generated method stub
		groupRepository.deleteById(id);
	}

//	@Override
//	public List<Group> findGroup(Long id) {
//		// TODO Auto-generated method stub
//		return groupRepository.findAllById(id);
//	}

	@Override
	public void deleteStudent(long id) {
		studentRepository.deleteById(id);
		
	}

	@Override
	public List<Student> findStudent(long id) {
		// TODO Auto-generated method stub
		return studentRepository.findAllById(Arrays.asList(id));
	}

	@Override
	public List<Group> findGroup(long id) {
		// TODO Auto-generated method stub
		return groupRepository.findAllById(Arrays.asList(id));
	}

	
	
	

}

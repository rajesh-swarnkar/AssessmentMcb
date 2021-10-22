package com.mcb.assessment.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="marks")
public class Marks {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long markId;
	private Long studentId;
	private Long subjectId;
	private Date date;
	private Long marks ;
	
	
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public Long getMarkId() {
		return markId;
	}
	public void setMarkId(Long markId) {
		this.markId = markId;
	}
	public Long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Long subject_id) {
		this.subjectId = subject_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getMarks() {
		return marks;
	}
	public void setMarks(Long marks) {
		this.marks = marks;
	}
	
	
		
	

}

package com.mcb.assessment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="grup")
public class Group {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="group_id")
	private Long groupId;
	private String name;
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long group_id) {
		this.groupId = group_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}

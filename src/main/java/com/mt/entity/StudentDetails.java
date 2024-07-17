package com.mt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="STUDENT_DETAILS")
@Data
public class StudentDetails {
	
	@Id
	@Column(name="STUDENT_ID",length=4)
	private Integer studentId;
	
	@Column(name="STUDENT_NAME")
	private String studentName;
	
	@Column(name="BRANCH")
	private String branch;
	
	@Column(name="EMAIL",length=20)
	private String email;
	
	@Column(name="REGULATION")
	private String regulation;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="ACTIVE_SW",length=15)
	private String activeSW="active";

}

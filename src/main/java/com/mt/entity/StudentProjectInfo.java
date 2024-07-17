package com.mt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="STUDENT_PROJECT_DETAILS")
@Data
public class StudentProjectInfo {
	
	@Id
	@Column(name="PROJECT_CODE")
	private Integer projectCode;
	
	@Column(name="PROJECT_NAME")
	private String projectName;
	
	@Column(name="SUBJECT")
	private String subject;
	
	@Column(name="PROJECT_SUBMISSION")
	@CreationTimestamp
	private LocalDateTime submission;
	
	@Column(name="PROJECT_LEAD")
	private String projectLead;
	
	@Column(name="ACTIVE_SW",length=15)
	private String activeSW="active";
	
	

}

package com.mt.service;

import java.util.List;
import java.util.Map;

import com.mt.entity.StudentProjectInfo;

public interface IStudentProjectInfoMgmtService {
	
	//save operation
	public String registerStudentProjectInfo(StudentProjectInfo projInfo);
	
	//for select operation
	public Map<Integer,String> getStudentProjectInfo();

	//for group selection operation
	public List<StudentProjectInfo> showAllStudentProjectInfo();
	
	//for edit operation from launch(To show the existing record for edit
	public StudentProjectInfo showStudentProjectInfoByCode(Integer projectCode);
	
	//for edit operation form submission
	public String updateStudentProjectInfo(StudentProjectInfo project);
	
	//for deletion operation(hard deletion)
	public String delectStudentProjectInfo(Integer projectCode);
	
	//for soft deletion
	public String changeStudentProjectInfoStatus(Integer projectCode,String status);
	
}

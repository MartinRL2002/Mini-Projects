package com.mt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.mt.entity.StudentDetails;
import com.mt.entity.StudentProjectInfo;
import com.mt.repository.IStudentDetailsRepository;
import com.mt.repository.IStudentProjectInfoRepository;

@Service
public class StudentProjectInfoMgmtServiceImpl implements IStudentProjectInfoMgmtService {

	@Autowired
	private IStudentDetailsRepository studDetailsRepo;
	
	@Autowired
	private IStudentProjectInfoRepository studProjectRepo;
	
	@Override
	public String registerStudentProjectInfo(StudentProjectInfo projInfo) {
		// save the details
		StudentProjectInfo saved=studProjectRepo.save(projInfo);
		return saved.getProjectCode()!=null?"Student Project Inforamtion is saved with Code:: "+saved.getProjectCode():"Problem in saving Student Project Information";
	}

	@Override
	public Map<Integer, String> getStudentProjectInfo() {
		// get all Project Information
		
		List<StudentProjectInfo> list=studProjectRepo.findAll();
		Map<Integer, String> detailsMap=new HashMap<Integer,String>();
		list.forEach(details->{
			detailsMap.put(details.getProjectCode(),details.getProjectName());
		});
		return detailsMap;
	}

	
	@Override
	public List<StudentProjectInfo> showAllStudentProjectInfo() {
		// finding all Information
				return studProjectRepo.findAll();
	}

	@Override
	public StudentProjectInfo showStudentProjectInfoByCode(Integer projectCode) {
		// finding by Id value
		return studProjectRepo.findById(projectCode).orElseThrow(()->new IllegalArgumentException("Project Information is not Found"));
	}

	@Override
	public String updateStudentProjectInfo(StudentProjectInfo project) {
		// update project information
		Optional<StudentProjectInfo> opt=studProjectRepo.findById(project.getProjectCode());
		if(opt.isPresent()) {
			//update the project
			studProjectRepo.save(project);
			return project.getProjectCode()+"Project Information is updated";
		}else {
		return project.getProjectCode()+"Project Information is not found";
		}
	}

	@Override
	public String delectStudentProjectInfo(Integer projectCode) {
		Optional<StudentProjectInfo> opt=studProjectRepo.findById(projectCode);
				if(opt.isPresent()) {
					//update the Information
					studProjectRepo.deleteById(projectCode);
					return projectCode+ " Prject Information is deleted";
				}else {
		return projectCode+"Project Information Not Found";
		}
	}

	@Override
	public String changeStudentProjectInfoStatus(Integer projectCode, String status) {
		Optional<StudentProjectInfo> opt=studProjectRepo.findById(projectCode);
		if(opt.isPresent()) {
			StudentProjectInfo projInfo=opt.get();
			projInfo.setActiveSW(status);
			studProjectRepo.save(projInfo);
			return projectCode+" Project information Status is changed";
		}else {
		return projectCode+" Project Information is not found forupdation";
		}
	}

	

}

package com.mt.ms;

import java.util.List;
import java.util.Map;

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

import com.mt.entity.StudentProjectInfo;
import com.mt.service.IStudentProjectInfoMgmtService;

@RestController
@RequestMapping("/studetproject/api")
public class StudentProjectInfoOperationController {
	
	@Autowired
	IStudentProjectInfoMgmtService projectInfo;
	
	@GetMapping("/information")
	public ResponseEntity<?> showStudentProjectInformation(){
		// involve service methods
		try {
			Map<Integer,String> mapInformation=projectInfo.getStudentProjectInfo();
			return new ResponseEntity<Map<Integer,String>>(mapInformation,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> saveStudentProjectInfo(@RequestBody StudentProjectInfo info){
		// use service
		try {
			String msg=projectInfo.registerStudentProjectInfo(info);
			return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllStudentProjectInformation(){
		// involve service methods
		try {
			List<StudentProjectInfo> list=projectInfo.showAllStudentProjectInfo();
			return new ResponseEntity<List<StudentProjectInfo>>(list,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/find/{ProjectCode}")
	public ResponseEntity<?> getProjectInformationById(@PathVariable Integer projectId){
		//use service
		try {
			StudentProjectInfo Info=projectInfo.showStudentProjectInfoByCode(projectId);
			return new ResponseEntity<StudentProjectInfo>(Info,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}	
		
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<String> updateProjectInfo(@RequestBody StudentProjectInfo info){
		//use service
		try {
			String msg=projectInfo.updateStudentProjectInfo(info);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@DeleteMapping("/delete/{projectCode}")
	public ResponseEntity<String> removeStudentProjectInfoByProjectCode(@PathVariable Integer info){
		//use service
		try {
			String msg=projectInfo.delectStudentProjectInfo(info);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@PutMapping("/status-change/{ProjetcCode}/{status}")
	public ResponseEntity<?> removeStudentProjectByProjectCode(@PathVariable Integer projectCode, @PathVariable String status){
		//use service
		try {
			String msg=projectInfo.changeStudentProjectInfoStatus(projectCode, status);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

package com.mt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mt.entity.StudentProjectInfo;

public interface IStudentProjectInfoRepository extends JpaRepository<StudentProjectInfo, Integer> {

}

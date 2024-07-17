package com.mt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mt.entity.StudentDetails;

public interface IStudentDetailsRepository extends JpaRepository<StudentDetails, Integer> {

}

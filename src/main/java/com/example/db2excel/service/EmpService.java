package com.example.db2excel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.db2excel.entity.EmployeeInfo;
import com.example.db2excel.repository.EmpRepository;

@Service
public class EmpService {

	@Autowired
	private EmpRepository empRepo;
	
	public List<EmployeeInfo> getEmpInfo(){
		List<EmployeeInfo> empInfo = empRepo.findAll();
		System.out.println("Joining Date: "+empInfo.get(6).getDateOfJoining());
		return empInfo;
	}
	
}

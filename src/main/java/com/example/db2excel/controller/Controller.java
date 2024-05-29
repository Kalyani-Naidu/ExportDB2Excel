package com.example.db2excel.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.db2excel.entity.EmployeeInfo;
import com.example.db2excel.excelExporter.ExcelExporter;
import com.example.db2excel.service.EmpService;

import jakarta.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	private EmpService service;
	
	@GetMapping("/export/data/excel/emplist")
	public void exportToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = formatDate.format(new Date());
		
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=\"Employees_" + currentDateTime + ".xlsx\"";
		response.setHeader(headerKey, headerValue);
		
		List<EmployeeInfo> empList = service.getEmpInfo();
		
		ExcelExporter excelExporter = new ExcelExporter(empList);
		excelExporter.export(response);
		
	}

}

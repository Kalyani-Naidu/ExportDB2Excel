package com.example.db2excel.excelExporter;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.db2excel.entity.EmployeeInfo;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

public class ExcelExporter {
	
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private List<EmployeeInfo> empList;
	
	
	public ExcelExporter(List<EmployeeInfo> empList) {
		this.empList = empList;
		workbook = new XSSFWorkbook();
	}
	
	private void createCell(Row row, int columnCount, Object value, CellStyle style) {
		
		sheet.autoSizeColumn(columnCount);
		Cell cell = row.createCell(columnCount);
		
		 if (value instanceof Integer) {
			cell.setCellValue((Integer)value);
		}else if (value instanceof Boolean) {
			cell.setCellValue((Boolean)value);
		}else if (value instanceof String) {
			cell.setCellValue((String)value);
		}else if (value instanceof Double) {
			cell.setCellValue((Double)value);
		}else if (value instanceof Character) {
			cell.setCellValue(String.valueOf((Character)value));
		}else if (value instanceof Date) {
		    java.util.Date dateValue = (Date) value;
		    if (dateValue != null) {
		        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); 
		        cell.setCellValue(dateFormat.format(dateValue));
		    }
		}

		 
		 cell.setCellStyle(style);
	}
	
	private void writeHeaderLine() {
		sheet = workbook.createSheet("Employees");
		Row row = sheet.createRow(0);
		
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);
		
		createCell(row, 0, "EMPLOYEE ID", style);
		createCell(row, 1, "NAME", style);
		createCell(row, 2, "GENDER", style);
		createCell(row, 3, "AGE", style);
		createCell(row, 4, "JOINING DATE", style);
		createCell(row, 5, "DEPARTMENT", style);
		createCell(row, 6, "SALARY", style);
		createCell(row, 7, "DESIGNATION", style);
	}
	
	private void writeDataLines() {
		int rowCount = 1;
		
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);
		
		for(EmployeeInfo empInfo : empList) {
			Row row = sheet.createRow(rowCount++);
			
			int columnCount = 0;
			createCell(row, columnCount++, empInfo.getEmpId(), style);
			createCell(row, columnCount++, empInfo.getName(), style);
			createCell(row, columnCount++, empInfo.getGender(), style);
			createCell(row, columnCount++, empInfo.getAge(), style);
			createCell(row, columnCount++, empInfo.getDateOfJoining(), style);
			createCell(row, columnCount++, empInfo.getDepartment(), style);
			createCell(row, columnCount++, empInfo.getSalary(), style);
			createCell(row, columnCount++, empInfo.getDesignation(), style);
		}
	}
	
	public void export(HttpServletResponse response) throws IOException {
		writeHeaderLine();
		writeDataLines();
		
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		
		outputStream.close();
	}

}

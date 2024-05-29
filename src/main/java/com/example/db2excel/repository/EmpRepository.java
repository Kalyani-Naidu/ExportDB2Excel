package com.example.db2excel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.db2excel.entity.EmployeeInfo;

public interface EmpRepository extends JpaRepository<EmployeeInfo, Integer> {

}

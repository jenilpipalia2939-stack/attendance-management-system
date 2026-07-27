package com.jenilpipaliya.attendance.repository;

import com.jenilpipaliya.attendance.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

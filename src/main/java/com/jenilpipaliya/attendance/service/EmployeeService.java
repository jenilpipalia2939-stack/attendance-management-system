package com.jenilpipaliya.attendance.service;

import com.jenilpipaliya.attendance.entity.Employee;
import com.jenilpipaliya.attendance.exception.EmployeeNotFoundException;
import com.jenilpipaliya.attendance.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void addEmployee(Employee employee) {
            employeeRepository.save(employee);
    }

    public void deleteEmployee(int id) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("No employee found with id " + id));
        employeeRepository.delete(existingEmployee);
    }

    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(int id, Employee updatedDetails) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("No employee found with id " + id));
        existingEmployee.setName(updatedDetails.getName());
        existingEmployee.setEmail(updatedDetails.getEmail());
        existingEmployee.setPhone(updatedDetails.getPhone());
        existingEmployee.setAddress(updatedDetails.getAddress());
        existingEmployee.setManager(updatedDetails.getManager());
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }


}

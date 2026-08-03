package com.jenilpipaliya.attendance.service;

import com.jenilpipaliya.attendance.repository.AttendanceRepository;
import com.jenilpipaliya.attendance.repository.EmployeeRepository;

public class AttendanceService {

    private final EmployeeRepository employeeRepository;
    private final AttendanceRepository attendanceRepository;
    private final PhotoVerificationService verificationService;

    public AttendanceService(EmployeeRepository employeeRepository, AttendanceRepository attendanceRepository, PhotoVerificationService verificationService) {
        this.employeeRepository = employeeRepository;
        this.attendanceRepository = attendanceRepository;
        this.verificationService = verificationService;
    }
}

package com.jenilpipaliya.attendance.repository;

import com.jenilpipaliya.attendance.entity.Admin;
//import org.hibernate.internal.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
    Optional<Admin> findByUserName(String userName);
}

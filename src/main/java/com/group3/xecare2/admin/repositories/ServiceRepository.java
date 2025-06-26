package com.group3.xecare2.admin.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group3.xecare2.admin.entities.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
    
    // Tìm dịch vụ theo tên
    Optional<Service> findByName(String name);
    
    // Tìm dịch vụ đang hoạt động
    List<Service> findByIsActiveTrue();
    
    // Tìm dịch vụ theo tên (tìm kiếm mờ)
    List<Service> findByNameContainingIgnoreCase(String name);
    
    // Kiểm tra dịch vụ có tồn tại không
    boolean existsByName(String name);
} 
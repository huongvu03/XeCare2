package com.group3.xecare2.garage.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.group3.xecare2.user.entities.Appointment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Repair_Results")
public class RepairResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    private String summary;
    private BigDecimal totalCost;
    private LocalDateTime repairTime;
    private String imageUrl;
    private LocalDateTime createdAt = LocalDateTime.now();
}
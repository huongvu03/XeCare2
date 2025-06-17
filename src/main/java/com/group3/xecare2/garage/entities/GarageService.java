package com.group3.xecare2.garage.entities;

import java.math.BigDecimal;

import com.group3.xecare2.admin.entities.Service;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "Garage_Services", uniqueConstraints = @UniqueConstraint(columnNames = {"garage_id", "service_id"}))
public class GarageService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "garage_id")
    private Garage garage;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    private BigDecimal basePrice;
    private Integer estimatedTimeMinutes;
}
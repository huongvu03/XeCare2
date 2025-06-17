package com.group3.xecare2.garage.entities;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.group3.xecare2.enums.GarageStatus;
import com.group3.xecare2.user.entities.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Garages")
public class Garage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User owner;

    private String name;
    private String description;
    private String address;
    private String phone;
    private String email;
    private Double latitude;
    private Double longitude;
    private LocalTime openTime;
    private LocalTime closeTime;
    private String imageUrl;
    private Boolean isVerified = false;

    @Enumerated(EnumType.STRING)
    private GarageStatus status = GarageStatus.PENDING;

    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "garage", cascade = CascadeType.ALL)
    private List<GarageVehicleType> vehicleTypes;

    @OneToMany(mappedBy = "garage", cascade = CascadeType.ALL)
    private List<GarageService> services;
}

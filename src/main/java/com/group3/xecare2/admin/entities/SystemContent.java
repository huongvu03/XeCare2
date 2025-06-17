package com.group3.xecare2.admin.entities;

import java.time.LocalDateTime;

import com.group3.xecare2.enums.ContentType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "System_Contents")
public class SystemContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    @Enumerated(EnumType.STRING)
    private ContentType contentType;

    private String imageUrl;
    private LocalDateTime createdAt = LocalDateTime.now();


}

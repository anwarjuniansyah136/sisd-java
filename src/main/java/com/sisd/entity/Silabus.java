package com.sisd.entity;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "silabus")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Silabus {
    
    @Id
    @UuidGenerator
    @Column(name = "id", length = 36, nullable = false)
    private String id;

    @Column(name = "silabus_name")
    private String silabusName;

    @Column(name = "silabus_desc", length = 1000)
    private String silabusDesc;
}

package com.cibertec.edu.pe.persons.dao.entity;

import com.cibertec.edu.pe.persons.client.dto.SbsReportDto;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String documentNumber;
    private String fullName;
    private String phoneNumber;
    private String address;
    private String email;
    private String status;
    @Transient
    private SbsReportDto sbsReport;
}

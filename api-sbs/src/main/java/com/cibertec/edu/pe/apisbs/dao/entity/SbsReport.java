package com.cibertec.edu.pe.apisbs.dao.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class SbsReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String personDocumentNumber;
    private String personFullName;
    private String score;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "report")
    private Set<SbsReportDetail> detail;
}

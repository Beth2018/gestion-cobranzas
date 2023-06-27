package com.cibertec.edu.pe.apisbs.dao.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Data
@Entity
public class SbsReportDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Fetch(FetchMode.JOIN)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reportId")
    private SbsReport report;
    private String companyName;
    private String productName;
    private double amountDebt;
    private int dueDays;
}

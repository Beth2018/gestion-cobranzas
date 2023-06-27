package com.cibertec.edu.pe.persons.client.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SbsReportDetailDto implements Serializable {

    private String companyName;
    private String productName;
    private double amountDebt;
    private int dueDays;
}

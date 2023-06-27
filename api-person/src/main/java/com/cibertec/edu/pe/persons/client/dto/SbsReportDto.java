package com.cibertec.edu.pe.persons.client.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class SbsReportDto implements Serializable {

    private Long id;
    private String personDocumentNumber;
    private String personFullName;
    private String score;
    private List<SbsReportDetailDto> detail;
}

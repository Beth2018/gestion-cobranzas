package com.cibertec.edu.pe.apisbs.service;

import com.cibertec.edu.pe.apisbs.dao.entity.SbsReport;

import java.util.Optional;

public interface ISbsService {

    Optional<SbsReport> getSbsReport(String doi);
}

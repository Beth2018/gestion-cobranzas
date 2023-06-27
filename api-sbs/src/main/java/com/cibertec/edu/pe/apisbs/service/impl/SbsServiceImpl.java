package com.cibertec.edu.pe.apisbs.service.impl;

import com.cibertec.edu.pe.apisbs.dao.entity.SbsReport;
import com.cibertec.edu.pe.apisbs.dao.repository.ISbsReportRepository;
import com.cibertec.edu.pe.apisbs.service.ISbsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SbsServiceImpl implements ISbsService {

    private final ISbsReportRepository repository;

    @Override
    public Optional<SbsReport> getSbsReport(String doi) {
        SbsReport example = new SbsReport();
        example.setPersonDocumentNumber(doi);
        return repository.findOne(Example.of(example));
    }
}

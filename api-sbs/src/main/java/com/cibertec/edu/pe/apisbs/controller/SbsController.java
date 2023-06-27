package com.cibertec.edu.pe.apisbs.controller;

import com.cibertec.edu.pe.apisbs.dao.entity.SbsReport;
import com.cibertec.edu.pe.apisbs.service.ISbsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/sbs")
@RequiredArgsConstructor
public class SbsController {

    private final ISbsService service;

    @GetMapping("/report/{doi}")
    public ResponseEntity<SbsReport> getSbsReport(@PathVariable("doi") String doi) {
        Optional<SbsReport> sbsReportOptional = service.getSbsReport(doi);
        return sbsReportOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());

    }
}

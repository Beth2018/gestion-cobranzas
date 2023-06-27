package com.cibertec.edu.pe.persons.client.service;

import com.cibertec.edu.pe.persons.client.dto.SbsReportDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("api-sbs")
@CircuitBreaker(name = "api-sbs")
public interface ISbsClient {

    @GetMapping("api/sbs/report/{doi}")
    SbsReportDto getSbsReport(@PathVariable("doi") String doi);
}

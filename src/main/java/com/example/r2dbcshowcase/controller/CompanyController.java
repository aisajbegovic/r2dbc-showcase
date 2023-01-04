package com.example.r2dbcshowcase.controller;


import com.example.r2dbcshowcase.model.dto.CompanySimpleDto;
import com.example.r2dbcshowcase.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
public class CompanyController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyController.class);

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @MessageMapping("allCompanies")
    public Flux<CompanySimpleDto> currentMarketData() {
        LOGGER.info("Listing all companies...");
        return companyService.getAll();
    }
}

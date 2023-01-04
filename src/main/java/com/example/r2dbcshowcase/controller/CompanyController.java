package com.example.r2dbcshowcase.controller;


import com.example.r2dbcshowcase.model.dto.CompanyDetailsDto;
import com.example.r2dbcshowcase.model.dto.CompanySimpleDto;
import com.example.r2dbcshowcase.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyController.class);

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @MessageMapping("allCompanies")
    public Flux<CompanySimpleDto> allCompanies() {
        LOGGER.info("Listing all companies...");
        return companyService.getAll();
    }

    @RequestMapping(value="list/details/", method = RequestMethod.GET)
    public Flux<CompanyDetailsDto> allCompaniesWithOfficesInfo() {
        LOGGER.info("Listing all companies with offices...");

        return companyService.getAllWithOffices();
    }

    @RequestMapping(value="list/details/{uuid}", method = RequestMethod.GET)
    public Mono<CompanyDetailsDto> companyDetailsWithOfficesInfoById(@PathVariable(value = "uuid") UUID id) {
        LOGGER.info("Listing all companies with offices...");

        return companyService.getByIdWithOffices(id);
    }

    @RequestMapping(value="/{uuid}", method = RequestMethod.DELETE)
    public Mono<Void> deleteById(@PathVariable(value = "uuid") UUID id) {
        LOGGER.info("Listing all companies with offices...");

        return companyService.deleteById(id).onErrorResume(e -> Mono.empty());
    }
}

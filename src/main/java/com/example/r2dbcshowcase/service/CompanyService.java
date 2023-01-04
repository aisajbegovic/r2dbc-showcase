package com.example.r2dbcshowcase.service;

import com.example.r2dbcshowcase.model.dto.CompanySimpleDto;
import com.example.r2dbcshowcase.repository.CompanyRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;


    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Flux<CompanySimpleDto> getAll() {
        return companyRepository
                .findAll()
                .log()
                .map(CompanySimpleDto::fromEntity)
                .log();
    }
}

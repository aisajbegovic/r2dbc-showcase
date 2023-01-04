package com.example.r2dbcshowcase.service;

import com.example.r2dbcshowcase.model.dto.CompanyDetailsDto;
import com.example.r2dbcshowcase.model.dto.CompanySimpleDto;
import com.example.r2dbcshowcase.repository.CompanyRepository;
import com.example.r2dbcshowcase.repository.OfficeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final OfficeRepository officeRepository;


    public CompanyService(CompanyRepository companyRepository, OfficeRepository officeRepository) {
        this.companyRepository = companyRepository;
        this.officeRepository = officeRepository;
    }

    public Flux<CompanySimpleDto> getAll() {
        return companyRepository
                .findAll()
                .log()
                .map(CompanySimpleDto::fromEntity)
                .log();
    }

    public Flux<CompanyDetailsDto> getAllWithOffices() {
        return companyRepository
                .findAll()
                .log()
                .map(CompanyDetailsDto::fromEntity)
                .log();
    }

    @Transactional
    public Mono<CompanyDetailsDto> getByIdWithOffices(UUID id) {
        return companyRepository
                .findById(id)
                .log()
                .flatMap(e -> officeRepository.findAllByCompanyId(e.getId()).collectList().zipWith(Mono.just(e)))
                .map(e -> e.getT2().setOfficeList(e.getT1().stream().toList()))
                .map(CompanyDetailsDto::fromEntity)
                .log();
    }

    @Transactional
    public Mono<Void> deleteById(UUID id) {
        return companyRepository
                .deleteById(id)
                .then(officeRepository.deleteAllByCompanyId(id)
                        .then(Mono.error(RuntimeException::new))
                );
    }
}

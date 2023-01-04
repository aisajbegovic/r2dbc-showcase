package com.example.r2dbcshowcase.repository;

import com.example.r2dbcshowcase.model.Office;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface OfficeRepository extends R2dbcRepository<Office, UUID> {
    Flux<Office> findAllByCompanyId(UUID companyId);

    Mono<Void> deleteAllByCompanyId(UUID companyId);
}

package com.example.r2dbcshowcase.repository;

import com.example.r2dbcshowcase.model.Company;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompanyRepository extends R2dbcRepository<Company, UUID> {
}

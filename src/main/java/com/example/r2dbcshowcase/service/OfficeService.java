package com.example.r2dbcshowcase.service;

import com.example.r2dbcshowcase.model.Office;
import com.example.r2dbcshowcase.model.dto.OfficeSimpleDto;
import com.example.r2dbcshowcase.repository.OfficeRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Service
public class OfficeService {
    private final OfficeRepository officeRepository;


    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    public Flux<OfficeSimpleDto> getAllForCompanyId(UUID companyId) {
        return officeRepository
                .findAllByCompanyId(companyId)
                .log()
                .map(OfficeSimpleDto::fromEntity)
                .log();
    }
}

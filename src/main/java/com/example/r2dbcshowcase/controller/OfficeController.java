package com.example.r2dbcshowcase.controller;

import com.example.r2dbcshowcase.model.dto.OfficeSimpleDto;
import com.example.r2dbcshowcase.service.OfficeService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.UUID;

@RestController
@RequestMapping("/offices")
public class OfficeController {

    private final OfficeService officeService;

    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @RequestMapping(value="list/{companyId}", method = RequestMethod.GET)
    public Flux<OfficeSimpleDto> getAllForCompanyId(@PathVariable(value = "companyId") UUID id) {
        return officeService.getAllForCompanyId(id);
    }
}

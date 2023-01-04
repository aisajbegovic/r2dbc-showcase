package com.example.r2dbcshowcase.model.dto;

import com.example.r2dbcshowcase.model.Company;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CompanyDetailsDto {
    private UUID id;
    private String name;
    private String address;
    private String email;
    private List<OfficeSimpleDto> officeSimpleDtoList = new ArrayList<>(3);

    public UUID getId() {
        return id;
    }

    public CompanyDetailsDto setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CompanyDetailsDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public CompanyDetailsDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CompanyDetailsDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public List<OfficeSimpleDto> getOfficeSimpleDtoList() {
        return officeSimpleDtoList;
    }

    public CompanyDetailsDto setOfficeSimpleDtoList(List<OfficeSimpleDto> officeSimpleDtoList) {
        this.officeSimpleDtoList = officeSimpleDtoList;
        return this;
    }

    public CompanyDetailsDto addOffice(OfficeSimpleDto officeSimpleDto) {
        officeSimpleDtoList.add(officeSimpleDto);
        return this;
    }

    public static CompanyDetailsDto fromEntity(Company company) {
        CompanyDetailsDto companyDetailsDto = new CompanyDetailsDto()
                .setId(company.getId())
                .setAddress(company.getAddress())
                .setName(company.getName())
                .setEmail(company.getEmail());

        if (!company.getOfficeList().isEmpty()) {
            company.getOfficeList().forEach(e ->
                    companyDetailsDto.addOffice(OfficeSimpleDto.fromEntity(e)));
        }

        return companyDetailsDto;
    }

    @Override
    public String toString() {
        return "CompanyDetailsDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", officeSimpleDtoList=" + officeSimpleDtoList +
                '}';
    }
}

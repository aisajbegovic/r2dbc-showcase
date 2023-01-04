package com.example.r2dbcshowcase.model.dto;

import com.example.r2dbcshowcase.model.Company;

import java.util.UUID;

public class CompanySimpleDto {
    private UUID id;
    private String name;
    private String address;
    private String email;

    public UUID getId() {
        return id;
    }

    public CompanySimpleDto setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CompanySimpleDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public CompanySimpleDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CompanySimpleDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public static CompanySimpleDto fromEntity(Company company) {
        return new CompanySimpleDto()
                .setId(company.getId())
                .setEmail(company.getEmail())
                .setAddress(company.getAddress())
                .setName(company.getName());
    }
    @Override
    public String toString() {
        return "CompanySimpleDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

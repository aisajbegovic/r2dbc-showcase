package com.example.r2dbcshowcase.model;

import jakarta.persistence.Id;

import java.util.Objects;
import java.util.UUID;

import org.springframework.data.relational.core.mapping.Column;

public class Company {
    @Id
    private UUID id;
    private String name;
    @Column("hq_address")
    private String address;
    @Column("hq_email")
    private String email;
    @Column("web_home_page")
    private String homePage;

    public UUID getId() {
        return id;
    }

    public Company setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Company setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Company setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getHomePage() {
        return homePage;
    }

    public Company setHomePage(String homePage) {
        this.homePage = homePage;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(id, company.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", homePage='" + homePage + '\'' +
                '}';
    }
}

package com.example.r2dbcshowcase.model;

import org.springframework.data.annotation.Id;

import java.util.Objects;
import java.util.UUID;

public class Office {
    @Id
    private UUID id;

    private UUID companyId;
    private String address;
    private String officeEmail;
    private boolean owned;

    public UUID getId() {
        return id;
    }

    public Office setId(UUID id) {
        this.id = id;
        return this;
    }

    public UUID getCompanyId() {
        return companyId;
    }

    public Office setCompanyId(UUID companyId) {
        this.companyId = companyId;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Office setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getOfficeEmail() {
        return officeEmail;
    }

    public Office setOfficeEmail(String officeEmail) {
        this.officeEmail = officeEmail;
        return this;
    }

    public boolean isOwned() {
        return owned;
    }

    public Office setOwned(boolean owned) {
        this.owned = owned;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Office office = (Office) o;
        return owned == office.owned && Objects.equals(id, office.id) && Objects.equals(companyId, office.companyId) && Objects.equals(address, office.address) && Objects.equals(officeEmail, office.officeEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyId, address, officeEmail, owned);
    }

    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", address='" + address + '\'' +
                ", officeEmail='" + officeEmail + '\'' +
                ", owned=" + owned +
                '}';
    }
}

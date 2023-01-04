package com.example.r2dbcshowcase.model.dto;

import com.example.r2dbcshowcase.model.Office;

import java.util.Objects;
import java.util.UUID;

public class OfficeSimpleDto {
    private UUID id;
    private String address;
    private String officeEmail;
    private boolean owned;

    public UUID getId() {
        return id;
    }

    public OfficeSimpleDto setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public OfficeSimpleDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getOfficeEmail() {
        return officeEmail;
    }

    public OfficeSimpleDto setOfficeEmail(String officeEmail) {
        this.officeEmail = officeEmail;
        return this;
    }

    public boolean isOwned() {
        return owned;
    }

    public OfficeSimpleDto setOwned(boolean owned) {
        this.owned = owned;
        return this;
    }

    public static OfficeSimpleDto fromEntity(Office office) {
        return new OfficeSimpleDto()
                .setOwned(office.isOwned())
                .setAddress(office.getAddress())
                .setOfficeEmail(office.getOfficeEmail())
                .setId(office.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfficeSimpleDto that = (OfficeSimpleDto) o;
        return owned == that.owned && Objects.equals(id, that.id) && Objects.equals(address, that.address) && Objects.equals(officeEmail, that.officeEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, officeEmail, owned);
    }

    @Override
    public String toString() {
        return "OfficeSimpleDto{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", officeEmail='" + officeEmail + '\'' +
                ", owned=" + owned +
                '}';
    }
}

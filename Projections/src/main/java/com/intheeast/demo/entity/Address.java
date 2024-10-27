package com.intheeast.demo.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String zipCode;
    private String city;
    private String street;

    // Constructors, Getters, and Setters
    public Address() {}

    public Address(String zipCode, String city, String street) {
        this.zipCode = zipCode;
        this.city = city;
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
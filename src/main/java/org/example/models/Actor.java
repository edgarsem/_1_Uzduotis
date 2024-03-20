package org.example.models;

import java.time.LocalDateTime;

public class Actor {
    private String name;
    private String middleName;
    private String lastName;
    private LocalDateTime birthDate;

    public Actor(String name, String middleName, String lastName, LocalDateTime birthDate) {
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String middleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String lastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime birthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }
}

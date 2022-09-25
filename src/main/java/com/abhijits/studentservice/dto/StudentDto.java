package com.abhijits.studentservice.dto;

import com.abhijits.studentservice.domain.Gender;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class StudentDto {

    private UUID uuid;

    @NotNull(message = "'firstName' should not be null.")
    private String firstName;

    @NotNull(message = "'lastName' should not be null.")
    private String lastName;

    @NotNull
    private double age;

    @NotNull(message = "'gender' should be one of MALE, FEMALE, OTHER")
    private Gender gender;

    @NotNull
    private int standard;

    public UUID getUuid() {
        return uuid;
    }

    public StudentDto setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public StudentDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public StudentDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public double getAge() {
        return age;
    }

    public StudentDto setAge(double age) {
        this.age = age;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public StudentDto setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public int getStandard() {
        return standard;
    }

    public StudentDto setStandard(int standard) {
        this.standard = standard;
        return this;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "uuid=" + uuid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", standard=" + standard +
                '}';
    }

}

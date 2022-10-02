package com.abhijits.studentservice.dto;

import com.abhijits.studentservice.domain.Gender;

import javax.validation.constraints.*;
import java.util.UUID;

public class StudentDto {

    private UUID uuid;

    @NotBlank(message = "'firstName' should not be Empty or null.")
    @Pattern(regexp = "^[A-Za-z]+$", message = "'firstName' should only contain alphabets.")
    private String firstName;

    @NotBlank(message = "'lastName' should not be Empty or null.")
    @Pattern(regexp = "^[A-Za-z]+$", message = "'lastName' should only contain alphabets.")
    private String lastName;

    @NotNull(message = "'age' should not be null.")
    @Min(value = 4, message = "'age' minimum valid age is 4.")
    @Max(value = 99, message = "'age' maximum valid age is 99.")
    private double age;

    @NotNull(message = "'gender' should not be null.")
    private Gender gender;

    @NotNull(message = "'standard' should not be null.")
    @Min(value = 1, message = "'standard' minimum valid age is 1.")
    @Max(value = 12, message = "'standard' maximum valid age is 12.")
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

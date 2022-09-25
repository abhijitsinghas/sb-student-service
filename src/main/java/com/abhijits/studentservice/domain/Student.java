package com.abhijits.studentservice.domain;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by   : Abhijit Singh
 * On           : 24 September, 2022
 */
@Entity
public class Student {

    @Id
    @Column(columnDefinition = "UUID")
    private UUID uuid = UUID.randomUUID();

    @Column(nullable = false)
    private String firstName;

    @Column
    private String lastName;

    @Column(nullable = false)
    private double age;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    @Column(nullable = false)
    private int standard;

    public UUID getUuid() {
        return uuid;
    }

    public Student setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Student setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public double getAge() {
        return age;
    }

    public Student setAge(double age) {
        this.age = age;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public Student setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public int getStandard() {
        return standard;
    }

    public Student setStandard(int standard) {
        this.standard = standard;
        return this;
    }

    @Override
    public String toString() {
        return "Student{" +
                "uuid=" + uuid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", standard=" + standard +
                '}';
    }
}

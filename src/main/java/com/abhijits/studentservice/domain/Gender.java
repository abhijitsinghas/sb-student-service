package com.abhijits.studentservice.domain;

/**
 * Created by   : Abhijit Singh
 * On           : 24 September, 2022
 */
public enum Gender {

    MALE("MALE"),
    FEMALE("FEMALE"),
    OTHER("OTHER");

    private String value;

    private Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Gender setValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "value='" + value + '\'' +
                '}';
    }
}

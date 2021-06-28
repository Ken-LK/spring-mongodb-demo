package com.example.mongodb.bean;

import com.github.javafaker.Address;
import org.springframework.data.annotation.Id;

/**
 * @author ken
 * @className Person
 * @description TODO
 * @date 2021/6/25 4:33 下午
 **/
public class Person {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



}
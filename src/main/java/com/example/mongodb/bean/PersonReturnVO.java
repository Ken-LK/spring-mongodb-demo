package com.example.mongodb.bean;

import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * @author ken
 * @className PersonVO
 * @description TODO
 * @date 2021/6/25 9:10 下午
 **/
public class PersonReturnVO {

    @Id
    private Long id;

    private Person personList;

    private String teacher;

    private String favoriate;


    public Person getPersonList() {
        return personList;
    }

    public void setPersonList(Person personList) {
        this.personList = personList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getFavoriate() {
        return favoriate;
    }

    public void setFavoriate(String favoriate) {
        this.favoriate = favoriate;
    }
}
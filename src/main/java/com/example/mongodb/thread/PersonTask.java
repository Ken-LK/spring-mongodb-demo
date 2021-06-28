package com.example.mongodb.thread;

import com.example.mongodb.bean.Person;
import com.example.mongodb.repository.PersonRepository;
import com.github.javafaker.Faker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ken
 * @className PersonTask
 * @description TODO
 * @date 2021/6/25 5:11 下午
 */
public class PersonTask extends Thread {

    private PersonRepository personRepository;

    private List<Person> personList;

    public PersonTask(List<Person> personList,PersonRepository personRepository) {
        this.personList = personList;
        this.personRepository = personRepository;
    }

    @Override
    public void run() {

        List<Person> persons = new ArrayList<>();
        System.out.println(
                LocalDateTime.now() + "  " + Thread.currentThread().getName() + "start ");
        for (int i = 0; i < 10; i++) {

            persons.add(buildPerson());
        }
        addPersonList(persons);


        System.out.println(LocalDateTime.now() + "  " + Thread.currentThread().getName() + "end ");
    }

    private Person buildPerson() {

        Faker faker = new Faker();

        Person person = new Person();

        person.setId(faker.random().nextLong(2000));

        person.setFirstName(faker.name().firstName());
        person.setLastName(faker.name().lastName());
        person.setAge(faker.number().randomDigitNotZero());
        person.setPhoneNumber(faker.phoneNumber().phoneNumber());


        return person;
    }

    private synchronized void addPersonList(List<Person> list){
        System.out.println(Thread.currentThread().getName() + " 添加数据");
        personList.addAll(list);
    }
}

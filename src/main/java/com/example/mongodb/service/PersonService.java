package com.example.mongodb.service;

import com.example.mongodb.bean.Person;
import com.example.mongodb.bean.PersonVO;
import com.example.mongodb.repository.PersonRepository;
import com.example.mongodb.repository.PersonVORepository;
import com.example.mongodb.thread.PersonTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author ken
 * @className PersonService
 * @description TODO
 * @date 2021/6/25 5:09 下午
 */
@Service
public class PersonService {

    @Autowired private ExecutorService personExecutor;

    @Autowired private PersonRepository personRepository;

    @Autowired private PersonVORepository personVORepository;

    public  int generatePersonList() {

        List<Person> personList = new ArrayList<>();

        PersonTask personTask = new PersonTask(personList,personRepository);

        for (int i = 0; i < 10; i++) {
            personExecutor.submit(personTask);
        }

        personExecutor.shutdown();

        try {
            personExecutor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

            System.out.println("==="+personList.size());
        }


        PersonVO personVO = new PersonVO();

        personVO.setPersonList(personList);

        personVO.setFavoriate("吃饭");
        personVO.setTeacher("小马哥");

        personVO.setId(new Random().nextLong());

        personVORepository.save(personVO);




        return 0;
    }
}

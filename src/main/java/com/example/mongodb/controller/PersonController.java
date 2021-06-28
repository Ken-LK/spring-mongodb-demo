package com.example.mongodb.controller;

import com.example.mongodb.bean.Person;
import com.example.mongodb.bean.PersonReturnVO;
import com.example.mongodb.bean.PersonVO;
import com.example.mongodb.repository.PersonRepository;
import com.example.mongodb.repository.PersonVORepository;
import com.example.mongodb.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ken
 * @className PersonController
 * @description TODO
 * @date 2021/6/25 4:38 下午
 */
@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired private PersonRepository personRepository;

    @Autowired private PersonVORepository personVORepository;

    @Autowired private PersonService personService;

    @Autowired
    private MongoTemplate mongoTemplate;


    @PostMapping("save")
    public ResponseEntity<Person> save(@RequestBody Person person) {
        Person savePerson = personRepository.save(person);

        return ResponseEntity.ok(savePerson);
    }

    @GetMapping("buildPersons")
    public ResponseEntity<Integer> buildPersons() {

        int personNum = personService.generatePersonList();

        return ResponseEntity.ok(personNum);
    }


    @DeleteMapping("deletePersons")
    public ResponseEntity<Boolean> deletePersons() {

        personRepository.deleteAll();

        return ResponseEntity.ok(true);
    }

    @PostMapping("getPersonVO")
    public ResponseEntity<List<PersonReturnVO>> getPersonVO() {


        List<String> names = new ArrayList<>();

        names.add("Tish");
        names.add("Juana");


//        Criteria annemarie = Criteria.where("personList.age").is(4);


        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.unwind("personList"),
                Aggregation.match(Criteria.where("personList.firstName").in(names)));

//        Query query = new Query(annemarie);

        AggregationResults<PersonReturnVO> personVOS = mongoTemplate.aggregate(aggregation, PersonVO.class, PersonReturnVO.class);
        List<PersonReturnVO> mappedResults = personVOS.getMappedResults();


        return ResponseEntity.ok(mappedResults);
    }
}

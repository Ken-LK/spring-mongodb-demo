package com.example.mongodb.repository;

import com.example.mongodb.bean.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author <a href="mailto:liukailk.ken@gmail.com"> Ken </a>
 * @date 2021/6/25 4:37 下午
 **/
public interface PersonRepository extends MongoRepository<Person,Long> {
}

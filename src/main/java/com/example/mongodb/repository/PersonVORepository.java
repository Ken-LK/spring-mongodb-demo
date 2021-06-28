package com.example.mongodb.repository;

import com.example.mongodb.bean.PersonVO;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author <a href="mailto:liukailk.ken@gmail.com"> Ken </a>
 * @date 2021/6/25 9:12 下午
 **/
public interface PersonVORepository extends MongoRepository<PersonVO,Long> {
}

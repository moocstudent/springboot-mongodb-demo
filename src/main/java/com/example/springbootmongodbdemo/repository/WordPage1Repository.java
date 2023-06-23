package com.example.springbootmongodbdemo.repository;

import com.example.springbootmongodbdemo.domain.WordPage1;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author zhangqi
 * @date 2023/6/23
 * @time 12:53
 * @description
 */
public interface WordPage1Repository extends MongoRepository<WordPage1,String> {

    List<WordPage1> findByName(String name);
}

package com.example.springbootmongodbdemo.wordMongoTest;

import com.alibaba.fastjson2.JSONObject;
import com.example.springbootmongodbdemo.domain.WordPage1;
import com.example.springbootmongodbdemo.enums.WordTypes;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.codecs.JsonObjectCodec;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.ExecutableRemoveOperation;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * @author zhangqi
 * @date 2023/6/23
 * @time 11:02
 * @description
 */
@SpringBootTest
public class WordPage1Test {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Test
    public void test1(){
        System.out.println(1);
    }
    @Test
    public void testWord(){
        if (mongoTemplate.collectionExists(WordTypes.WORD1.getCode())){
            mongoTemplate.dropCollection(WordTypes.WORD1.getCode());
        }
        MongoCollection<Document> collection = mongoTemplate.createCollection(WordTypes.WORD1.getCode());
        WordPage1 word1 = WordPage1.builder()
                .name("zhangsan")
                .age("10")
                .comment("测试")
                .isLucky(true)
                .isNice(true)
                .id("1000")
                .build();
        WordPage1 saved = mongoTemplate.save(word1, WordTypes.WORD1.getCode());
        System.out.println("word1:"+saved);
    }

    @Test
    public void testFind(){
        WordPage1 wordPage1 = mongoTemplate.findById(
                "1000", WordPage1.class);

        System.out.println("find:"+wordPage1);
        WordPage1 word2 = WordPage1.builder()
                .name("li4")
                .age("12")
                .comment("测试2")
                .isLucky(true)
                .isNice(false)
                .id("1001")
                .build();

        WordPage1 saved = mongoTemplate.save(word2, WordTypes.WORD1.getCode());
        System.out.println("word2:"+saved);

        System.out.println("searchById:"+mongoTemplate.find(
                query(where("id").is("1000")),WordPage1.class));

        List<WordPage1> wordPage1s = mongoTemplate.findAll(WordPage1.class, WordTypes.WORD1.getCode());
        wordPage1s.forEach(System.out::println);
        System.out.println();
    }

    @Test
    public void testUpdate(){
        UpdateResult result = mongoTemplate.updateFirst(query(where("name").is("zhangsan")),
                new Update().set("age", "14"),
                WordPage1.class);
        System.out.println("Update Result:"+ result.getModifiedCount());
        List<WordPage1> wordPage1s = mongoTemplate.findAll(WordPage1.class, WordTypes.WORD1.getCode());
        wordPage1s.forEach(System.out::println);
    }

    @Test
    public void testDel(){
        WordPage1 wordPage11001 = mongoTemplate.findById("1001", WordPage1.class);
        DeleteResult result = mongoTemplate.remove(wordPage11001);
        System.out.println(result.getDeletedCount());
    }

}

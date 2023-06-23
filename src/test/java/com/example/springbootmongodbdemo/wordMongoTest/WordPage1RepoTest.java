package com.example.springbootmongodbdemo.wordMongoTest;

import com.example.springbootmongodbdemo.domain.WordPage1;
import com.example.springbootmongodbdemo.repository.WordPage1Repository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author zhangqi
 * @date 2023/6/23
 * @time 12:54
 * @description
 */
@SpringBootTest
public class WordPage1RepoTest {
    @Autowired
    private WordPage1Repository wordPage1Repository;

    @Test
    public void testRepoSave(){
        WordPage1 word3 = WordPage1.builder()
                .name("wang5")
                .age("10")
                .comment("测试")
                .isLucky(true)
                .isNice(true)
                .id("1002")
                .build();
        WordPage1 saved = wordPage1Repository.save(word3);
        System.out.println("wang5:"+saved);
    }

    @Test
    public void testRepoFind(){
        List<WordPage1> zhangsan = wordPage1Repository.findByName("zhangsan");
        zhangsan.forEach(System.out::println);
        System.out.println();
        List<WordPage1> all = wordPage1Repository.findAll();
        all.forEach(System.out::println);
    }

    @Test
    public void testRepoUpdate(){
        List<WordPage1> list = wordPage1Repository.findByName("zhangsan");
        WordPage1 zhang3 = list.get(0);
        zhang3.setAge("15");
        WordPage1 updated = wordPage1Repository.save(zhang3);
        System.out.println("updated:"+updated);
    }

    @Test
    public void testRepoDelete(){
        wordPage1Repository.deleteById("1002");
    }

}

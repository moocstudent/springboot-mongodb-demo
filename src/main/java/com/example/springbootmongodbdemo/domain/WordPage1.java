package com.example.springbootmongodbdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author zhangqi
 * @date 2023/6/23
 * @time 11:00
 * @description
 */
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WordPage1 {
    @Id
    private String id;
    private String name;
    private String age;
    private Boolean isNice;

    private Boolean isLucky;

    private String comment;

}

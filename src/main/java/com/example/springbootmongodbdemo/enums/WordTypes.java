package com.example.springbootmongodbdemo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhangqi
 * @date 2023/6/23
 * @time 12:23
 * @description
 */
@Getter
@AllArgsConstructor
public enum WordTypes {

    WORD1("wordPage1","");

    private String code;
    private String desc;
}

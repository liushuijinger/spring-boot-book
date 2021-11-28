package com.shuijing.boot.es.entity.es;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021-11-28
 */
@Data
@Accessors(chain = true)
@Document(indexName = "article", createIndex = false)
public class Article {

    @Id
    private Long id;

    @Field(store = true, searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    private String author;

    @Field(store = true, searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    private String title;

    @Field(store = true, searchAnalyzer = "ik_max_word", analyzer = "ik_max_word")
    private String content;
}

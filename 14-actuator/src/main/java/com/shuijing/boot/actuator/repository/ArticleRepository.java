package com.shuijing.boot.actuator.repository;

import com.shuijing.boot.actuator.entity.es.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021-12-12
 */
public interface ArticleRepository extends ElasticsearchRepository<Article, Long> {

    Page<Article> findByTitleLike(String title, Pageable page);
}


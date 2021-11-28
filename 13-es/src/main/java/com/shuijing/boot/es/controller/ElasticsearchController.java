package com.shuijing.boot.es.controller;

import com.shuijing.boot.es.common.Result;
import com.shuijing.boot.es.entity.es.Article;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.core.query.UpdateQuery;
import org.springframework.data.elasticsearch.core.query.UpdateResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 刘水镜
 * @blog https://liushuijinger.blog.csdn.net
 * @date 2021-11-28
 */
@Api
@Slf4j
@RestController
@RequestMapping("/es")
public class ElasticsearchController {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;


    @PostMapping
    @ApiOperation("新增")
    public Result<Iterable<Article>> create(@RequestBody List<Article> articleList) {
        return Result.success(elasticsearchRestTemplate.save(articleList));
    }

    @PutMapping
    @ApiOperation("更新")
    public Result<UpdateResponse> update(@RequestParam String id,
                                         @RequestParam String title,
                                         @RequestParam String content) {

        Map<String, Object> params = new HashMap<>();
        params.put("title", title);
        params.put("content", content);

        Document document = Document.from(params);

        UpdateQuery updateQuery = UpdateQuery.builder(id)
                .withDocument(document)
                .build();

        return Result.success(elasticsearchRestTemplate.update(updateQuery,IndexCoordinates.of("article")));
    }


    @DeleteMapping
    @ApiOperation("删除")
    public Result<String> delete(@RequestParam String id) {
        return Result.success(elasticsearchRestTemplate.delete(id, Article.class));
    }

    @GetMapping
    @ApiOperation("搜索")
    public Result<SearchHits<Article>> search(String keyWord) {

        Pageable pageable = PageRequest.of(0,10);  // page 从第 0 页开始

        HighlightBuilder.Field highlightField = new HighlightBuilder.Field("title")
                .preTags("<span>")
                .postTags("</span>");

        Query query = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.multiMatchQuery(keyWord, "author","title","content"))
                .withHighlightFields(highlightField)
                .withPageable(pageable)
                .build();
        SearchHits<Article> search = elasticsearchRestTemplate.search(query, Article.class);
        return Result.success(search);
    }

    @GetMapping("/count")
    @ApiOperation("统计数量")
    public Result<Long> count(String keyWord) {// page 从第 0 页开始

        Query query = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.multiMatchQuery(keyWord, "author","title","content"))
                .build();

        return Result.success(elasticsearchRestTemplate.count(query, Article.class));
    }
}

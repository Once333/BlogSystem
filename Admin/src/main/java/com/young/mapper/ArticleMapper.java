package com.young.mapper;

import com.young.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ArticleMapper {
    List<Article> getArticles();

    List<Article> findByPager(Map<String, Object> params);

    List<Article> getArticlesByCid(int cid);

    List<Article> getArticlesByTime(String fid);

    Article getArticleById(int id);

    Article getArticleByName(String name);

    void addArticle(Article article);

    void deleteArticleById(int id);

    void updateArticle(Article article);

    int count();

    int countSameCategory(int cid);

    int countSameTime(String fid);

    List<String> time();
}

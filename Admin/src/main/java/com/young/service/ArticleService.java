package com.young.service;

import com.young.mapper.ArticleMapper;
import com.young.pojo.Article;
import com.young.pojo.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    public List<Article> getArticles() {
        return articleMapper.getArticles();
    }

    public Pager<Article> findByPager(int page,int size) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("page",(page-1)*size);
        params.put("size",size);
        Pager<Article> pager = new Pager<>();
        List<Article> list = articleMapper.findByPager(params);
        pager.setRows(list);
        pager.setTotal(articleMapper.count());
        return pager;
    }

    public List<Article> getArticlesByCid(int cid) {
        return articleMapper.getArticlesByCid(cid);
    }

    public List<Article> getArticlesByTime(String fid) {
        return articleMapper.getArticlesByTime(fid);
    }

    public Article getArticleById(int id) {
        return articleMapper.getArticleById(id);
    }

    public Article getArticleByName(String name) {
        return articleMapper.getArticleByName(name);
    }

    public void addArticle(Article article) {
        articleMapper.addArticle(article);
    }

    public void deleteArticleById(int id) {
        articleMapper.deleteArticleById(id);
    }

    public void updateArticle(Article article) {
        articleMapper.updateArticle(article);
    }

    public int count() {
        return articleMapper.count();
    }

    public List<String> time() {
        return articleMapper.time();
    }
}

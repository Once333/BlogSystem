package com.young.controller;

import com.young.pojo.Article;
import com.young.pojo.Category;
import com.young.pojo.Pager;
import com.young.service.ArticleService;
import com.young.service.CategoryService;
import com.young.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class DataController {
    @Autowired
    ArticleService articleService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    TagService tagService;

    //前端与后端接口
    @GetMapping("/article/findAll/{page}/{size}")
    @CrossOrigin
    public Pager<Article> findByPager(@PathVariable("page") Integer page,@PathVariable("size") Integer size) {
        Pager<Article> pager = articleService.findByPager(page, size);
        List<Article> articles = pager.getRows();
        for(Article article: articles) {
            article.setCname(categoryService.getCatetoryName(article.getCategory()));
            article.setTname(tagService.getTagName(article.getTag()));
            byte[] data = null;
            try {
                InputStream in = new FileInputStream(article.getImage());
                data = new byte[in.available()];
                in.read(data);
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Base64.Encoder encoder = Base64.getEncoder();
            article.setCover(encoder.encodeToString(data));
        }
        pager.setRows(articles);
        return pager;
    }

    @GetMapping("/article/{id}")
    @CrossOrigin
    public Article findArticle(@PathVariable("id")int id) throws IOException {
        Article article = articleService.getArticleById(id);
        article.setCname(categoryService.getCatetoryName(article.getCategory()));
        article.setTname(tagService.getTagName(article.getTag()));
        String md = null;
        FileReader fr = new FileReader(article.getPath());
        char[] buf = new char[1024];
        int num = 0;
        while((num = fr.read(buf))!=-1){
            md += new String(buf,0,num);
        }
        article.setContent(md);
        return article;
    }

    @GetMapping("/category/findAll")
    @CrossOrigin
    public List<Category> findCategories() {
        List<Category> categories = categoryService.getCategories();
        return categories;
    }

    @GetMapping("/category-{id}/articles")
    @CrossOrigin
    public List<Article> findArticlesByCid(@PathVariable("id") Integer id) {
        List<Article> articles = articleService.getArticlesByCid(id);
        for(Article article: articles) {
            article.setCname(categoryService.getCatetoryName(article.getCategory()));
            article.setTname(tagService.getTagName(article.getTag()));
            byte[] data = null;
            try {
                InputStream in = new FileInputStream(article.getImage());
                data = new byte[in.available()];
                in.read(data);
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Base64.Encoder encoder = Base64.getEncoder();
            article.setCover(encoder.encodeToString(data));
        }
        return articles;
    }

    @GetMapping("/tag/findAll")
    @CrossOrigin
    public List<String> findTags() {
        List<String> tags = tagService.getTagNames();
        return tags;
    }

    @GetMapping("/file/findAll")
    @CrossOrigin
    public Map<String,String> time() {
        List<String> times = articleService.time();
        Map<String, String> map = new LinkedHashMap<>();
        for(String time: times) {
            if(map.containsKey(time)) {
                map.put(time,String.valueOf(1+Integer.valueOf(map.get(time))));
            }else {
                map.put(time,String.valueOf(1));
            }
        }
        return map;
    }

    @GetMapping("/file/{fid}")
    @CrossOrigin
    public List<Article> fileArticle(@PathVariable("fid") String fid) {
        List<Article> articles = articleService.getArticlesByTime(fid+'%');
        for(Article article: articles) {
            article.setCname(categoryService.getCatetoryName(article.getCategory()));
            article.setTname(tagService.getTagName(article.getTag()));
            byte[] data = null;
            try {
                InputStream in = new FileInputStream(article.getImage());
                data = new byte[in.available()];
                in.read(data);
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Base64.Encoder encoder = Base64.getEncoder();
            article.setCover(encoder.encodeToString(data));
        }
        return articles;
    }
}

package com.young.controller;

import com.young.pojo.Article;
import com.young.pojo.Category;
import com.young.pojo.Tag;
import com.young.service.ArticleService;
import com.young.service.CategoryService;
import com.young.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TagService tagService;

    @RequestMapping("/article")
    public String articles(Model model) {
        List<Article> articles = articleService.getArticles();
        model.addAttribute("articles",articles);
        return "article";
    }

    @GetMapping("/article/add")
    public String toAdd(Model model) {
        List<Category> categories = categoryService.getCategories();
        List<Tag> tags = tagService.getTags();
        model.addAttribute("categories",categories);
        model.addAttribute("tags",tags);
        return "add";
    }

    @PostMapping("/article/edit/{id}")
    public String toEdit(@PathVariable("id") Integer id,Model model) {
        Article article = articleService.getArticleById(id);
        List<Category> categories = categoryService.getCategories();
        List<Tag> tags = tagService.getTags();
        model.addAttribute("categories",categories);
        model.addAttribute("tags",tags);
        model.addAttribute("title",article.getTitle());
        model.addAttribute("path",article.getPath());
        model.addAttribute("category",categoryService.getCategoryById(article.getCategory()).getName());
        model.addAttribute("tag",tagService.getTagById(article.getTag()).getName());
        model.addAttribute("time",article.getTime());
        model.addAttribute("image",article.getImage());
        model.addAttribute("id", article.getId());
        return "edit";
    }

    //新增文章
    @PostMapping("/article/publish")
    public String publish(String title, String category, String tag, String time, MultipartFile path, MultipartFile image) throws IOException {
        String fileName = path.getOriginalFilename();
        String filePath = "/root/Article/";
        File targetFile = new File(filePath,fileName);
        path.transferTo(targetFile);
        String imageName = image.getOriginalFilename();
        String imagePath = "/root/cover/";
        File targetImage = new File(imagePath,imageName);
        image.transferTo(targetImage);
        List<Category> categories = categoryService.getCategories();
        List<Tag> tags = tagService.getTags();
        Category c0 = categoryService.getCategoryByName(category);
        Tag t0 = tagService.getTagByName(tag);
        int aid = articleService.count()+1;
        int cid = 0;
        int tid = 0;
        if(c0 == null) {
            cid = categories.size() + 1;
            Category c = new Category(cid,category,1);
            categoryService.addCategory(c);
        }else {
            cid = categories.indexOf(c0) +1;
            c0.setNumber(c0.getNumber()+1);
            categoryService.updateCategory(c0);
        }
        if(t0 == null) {
            tid = tags.size() + 1;
            Tag t = new Tag(tid,tag,1);
            tagService.addTag(t);
        }else {
            tid = tags.indexOf(t0) + 1;
            t0.setNumber(t0.getNumber()+1);
            tagService.updateTag(t0);
        }
        Article article = new Article(aid, title, filePath+fileName, cid, tid, time, imagePath+imageName);
        articleService.addArticle(article);
        return "redirect:/article";
    }

    //编辑文章
    @PostMapping("/article/edit")
    public String edit(int id,String title, String category, String tag, String time, MultipartFile path, MultipartFile image) throws IOException {
        Article article = articleService.getArticleById(id);
        File oldFile = new File(article.getContent());
        oldFile.delete();
        File oldImage = new File(article.getImage());
        oldImage.delete();
        String fileName = path.getOriginalFilename();
        String filePath = "/root/Article/";
        File targetFile = new File(filePath,fileName);
        path.transferTo(targetFile);
        String imageName = image.getOriginalFilename();
        String imagePath = "/root/cover/";
        File targetImage = new File(imagePath,imageName);
        image.transferTo(targetImage);
        article.setTitle(title);
        article.setContent(filePath+fileName);
        article.setImage(imagePath+imageName);
        List<Category> categories = categoryService.getCategories();
        Category c0 = categoryService.getCategoryByName(category);
        article.setCategory(categories.indexOf(c0)+1);
        List<Tag> tags = tagService.getTags();
        Tag t0 = tagService.getTagByName(tag);
        article.setTag(tags.indexOf(t0)+1);
        article.setTime(time);
        articleService.updateArticle(article);
        return "redirect:/article";
    }

    //删除文章
    @PostMapping("/article/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        Article article = articleService.getArticleById(id);
        File targetFile = new File(article.getPath());
        targetFile.delete();
        File targetImage = new File(article.getImage());
        targetImage.delete();
        Category category = categoryService.getCategoryById(article.getCategory());
        Tag tag = tagService.getTagById(article.getTag());
        category.setNumber(category.getNumber()-1);
        categoryService.updateCategory(category);
        tag.setNumber(tag.getNumber()-1);
        tagService.updateTag(tag);
        articleService.deleteArticleById(id);
        return "redirect:/article";
    }
}

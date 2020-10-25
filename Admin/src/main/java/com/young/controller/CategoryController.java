package com.young.controller;

import com.young.pojo.Category;
import com.young.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/category")
    public String category(Model model) {
        List<Category> categories = categoryService.getCategories();
        model.addAttribute("categories",categories);
        return "category";
    }

    //新增分类
    @PostMapping("/category/add")
    public String add(@RequestParam("cname") String name,Model model) {
        List<Category> categories = categoryService.getCategories();
        Category category = categoryService.getCategoryByName(name);
        if(categories.contains(category)) {
            //发送已存在消息
        }else {
            int cid = categories.size() + 1;
            Category c = new Category(cid, name, 0);
            categoryService.addCategory(c);
        }
        return "redirect:/category";
    }

    //删除分类
    @PostMapping("/category/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        categoryService.deleteCategoryById(id);
        return "redirect:/category";
    }

}

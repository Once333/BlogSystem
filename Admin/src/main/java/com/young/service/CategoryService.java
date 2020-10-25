package com.young.service;

import com.young.mapper.CategoryMapper;
import com.young.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> getCategories(){
        return categoryMapper.getCategories();
    }

    public Category getCategoryById(int id){
        return categoryMapper.getCategoryById(id);
    }

    public String getCatetoryName(int id) {
        return categoryMapper.getCategoryById(id).getName();
    }

    public Category getCategoryByName(String name){
        return categoryMapper.getCategoryByName(name);
    }

    public void addCategory(Category category){
        categoryMapper.addCategory(category);
    }

    public void deleteCategoryById(int id){
        categoryMapper.deleteCategoryById(id);
    }

    public void updateCategory(Category category) {
        categoryMapper.updateCategory(category);
    }
}

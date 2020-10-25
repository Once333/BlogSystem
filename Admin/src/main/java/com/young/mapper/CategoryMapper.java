package com.young.mapper;

import com.young.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryMapper {
    List<Category> getCategories();

    Category getCategoryById(int id);

    Category getCategoryByName(String name);

    void addCategory(Category category);

    void deleteCategoryById(int id);

    void updateCategory(Category category);
}

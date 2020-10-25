package com.young.mapper;

import com.young.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TagMapper {
    List<Tag> getTags();

    List<String> getTagNames();

    Tag getTagById(int id);

    Tag getTagByName(String name);

    void addTag(Tag tag);

    void deleteTagById(int id);

    void updateTag(Tag tag);
}

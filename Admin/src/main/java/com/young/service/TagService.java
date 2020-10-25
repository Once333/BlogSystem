package com.young.service;

import com.young.mapper.TagMapper;
import com.young.pojo.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    @Autowired
    private TagMapper tagMapper;

    public List<Tag> getTags() {
        return tagMapper.getTags();
    }

    public List<String> getTagNames() {
        return tagMapper.getTagNames();
    }

    public Tag getTagById(int id) {
        return tagMapper.getTagById(id);
    }

    public String getTagName(int id) {
        return tagMapper.getTagById(id).getName();
    }

    public Tag getTagByName(String name) {
        return tagMapper.getTagByName(name);
    }

    public void addTag(Tag tag) {
        tagMapper.addTag(tag);
    }

    public void deleteTagById(int id) {
        tagMapper.deleteTagById(id);
    }

    public void updateTag(Tag tag) {
        tagMapper.updateTag(tag);
    }
}

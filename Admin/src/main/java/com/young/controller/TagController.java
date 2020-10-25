package com.young.controller;

import com.young.pojo.Tag;
import com.young.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TagController {
    @Autowired
    private TagService tagService;

    @RequestMapping("/tag")
    public String tag(Model model) {
        List<Tag> tags = tagService.getTags();
        model.addAttribute("tags",tags);
        return "tag";
    }

    //新增标签
    @PostMapping("/tag/add")
    public String add(@RequestParam("tname") String name, Model model) {
        List<Tag> tags = tagService.getTags();
        Tag tag = tagService.getTagByName(name);
        if(tags.contains(tag)) {
            //已存在标签
        }else {
            int tig = tags.size() + 1;
            Tag t = new Tag(tig, name, 0);
            tagService.addTag(t);
        }
        return "redirect:/tag";
    }

    //删除标签
    @PostMapping("/tag/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        tagService.deleteTagById(id);
        return "redirect:/tag";
    }
}

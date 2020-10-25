package com.young.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private int id;
    private String title;
    private String path;
    private int category;
    private int tag;
    private String time;
    private String image;

    private String cname;
    private String tname;
    private String content;
    private String cover;

    public Article(int id,String title,String path,int category,int tag,String time,String image) {
        this.id = id;
        this.title = title;
        this.path = path;
        this.category = category;
        this.tag = tag;
        this.time = time;
        this.image = image;
    }
}

package com.ben.domain.web.bean;

import com.ben.domain.jpa.entity.tag.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben on 8/30/2016.
 */
public class BlogBean {

    private String title;

    private String content;

    private List<Tag> tags = new ArrayList<Tag>();

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}

package com.ben.domain.jpa.entity.tag;

import com.ben.domain.jpa.entity.BaseDomainObject;
import com.ben.domain.jpa.entity.blog.Blog;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben on 8/26/2016.
 */
@Entity
public class Tag extends BaseDomainObject {

    private String name;

    @ManyToMany(mappedBy = "tags")
    @JsonIgnore
    private List<Blog> blogs = new ArrayList<Blog>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}

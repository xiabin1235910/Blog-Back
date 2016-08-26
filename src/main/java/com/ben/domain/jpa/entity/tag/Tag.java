package com.ben.domain.jpa.entity.tag;

import com.ben.domain.jpa.entity.blog.Blog;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben on 8/26/2016.
 */
@Entity
public class Tag {

    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Blog> blogs = new ArrayList<Blog>();
}

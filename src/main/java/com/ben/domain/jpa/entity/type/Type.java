/**
 * Created by Ben on 8/30/2016.
 */

package com.ben.domain.jpa.entity.type;

import com.ben.domain.jpa.entity.BaseDomainObject;
import com.ben.domain.jpa.entity.blog.Blog;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Type extends BaseDomainObject {

    @Column(nullable = false, unique = true)
    private String typename;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Blog> blogs = new ArrayList<Blog>();

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}

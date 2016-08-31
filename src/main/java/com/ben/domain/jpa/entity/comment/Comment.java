package com.ben.domain.jpa.entity.comment;

import com.ben.domain.jpa.entity.BaseDomainObject;
import com.ben.domain.jpa.entity.account.User;
import com.ben.domain.jpa.entity.blog.Blog;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by Ben on 8/26/2016.
 */
@Entity
public class Comment extends BaseDomainObject {

    @ManyToOne
    private User user;

    @ManyToOne
    private Blog blog;

    private String content;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

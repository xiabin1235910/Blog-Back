package com.ben.domain.jpa.entity.blog;

import com.ben.domain.jpa.entity.BaseDomainObject;
import com.ben.domain.jpa.entity.account.User;
import com.ben.domain.jpa.entity.comment.Comment;
import com.ben.domain.jpa.entity.tag.Tag;
import com.ben.domain.jpa.entity.type.Type;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben on 8/26/2016.
 */
@Entity
public class Blog extends BaseDomainObject {

    @Column(unique = true, nullable = false)
    private String title;

    private String content;

    private String contentAbstract;

    private int visitAmount;

    @ManyToOne
    private User user;

    @ManyToOne
    private Type type;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Tag> tags = new ArrayList<Tag>();

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<Comment> comments = new ArrayList<Comment>();

    public void addTag(Tag tag) {
        tags.add(tag);
        tag.getBlogs().add(this);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getVisitAmount() {
        return visitAmount;
    }

    public void setVisitAmount(int visitAmount) {
        this.visitAmount = visitAmount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getContentAbstract() {
        return contentAbstract;
    }

    public void setContentAbstract(String contentAbstract) {
        this.contentAbstract = contentAbstract;
    }
}

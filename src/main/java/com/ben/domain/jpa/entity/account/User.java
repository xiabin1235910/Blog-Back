package com.ben.domain.jpa.entity.account;

import com.ben.domain.jpa.entity.BaseDomainObject;
import com.ben.domain.jpa.entity.blog.Blog;
import com.ben.domain.jpa.entity.comment.Comment;
import com.ben.domain.jpa.entity.constants.UserType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben on 8/26/2016.
 */
@Entity
public class User extends BaseDomainObject {

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private UserType type;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    // common info
    private String name;
    private String phone;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Comment> comments = new ArrayList<Comment>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Blog> blogs = new ArrayList<Blog>();


}

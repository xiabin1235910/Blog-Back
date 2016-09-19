package com.ben.test.account;

import com.ben.domain.jpa.entity.blog.Blog;
import com.ben.domain.jpa.entity.tag.Tag;
import com.ben.domain.jpa.repository.BlogRepository;
import com.ben.test.BaseDatabaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben on 9/14/2016.
 */
public class AccountTest extends BaseDatabaseTest {

    @Autowired
    BlogRepository blogRepository;

    @Test
    public void add_test() {
        Blog blog = new Blog();
        blog.setTitle("好极了11");

        Tag tag = new Tag();
        tag.setName("sadf");

        blog.addTag(tag);

        System.out.println(blog.getTags().size());
//        blog.setTags(tags);

        blogRepository.save(blog);
    }
}

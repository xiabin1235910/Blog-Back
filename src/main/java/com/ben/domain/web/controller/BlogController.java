/**
 * Created by Ben on 8/26/2016.
 */

package com.ben.domain.web.controller;

import com.ben.domain.jpa.entity.blog.Blog;
import com.ben.domain.jpa.repository.BlogRepository;
import com.ben.domain.web.bean.BlogBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogController {

    @Autowired
    BlogRepository blogRepository;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String saveBlog(@RequestBody BlogBean blogBean) {
        System.out.println(blogBean.getTitle());
        System.out.println(blogBean.getTitle());

        Blog blog = new Blog();
        blog.setTitle(blogBean.getTitle());
        blog.setContent(blogBean.getContent());
        blog.setTags(blogBean.getTags());

        blogRepository.save(blog);

        return "save success";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody Blog getBlog() {
        Blog blog = blogRepository.findOne(Long.parseLong("1"));
        return blog;
    }

}

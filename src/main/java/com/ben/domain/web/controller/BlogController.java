/**
 * Created by Ben on 8/26/2016.
 */

package com.ben.domain.web.controller;

import com.ben.domain.jpa.entity.blog.Blog;
import com.ben.domain.jpa.entity.tag.Tag;
import com.ben.domain.jpa.repository.BlogRepository;
import com.ben.domain.jpa.repository.TagRepository;
import com.ben.domain.web.bean.BlogBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("blog")
public class BlogController {

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    TagRepository tagRepository;

    @RequestMapping(method = RequestMethod.POST)
    public String add(@RequestBody BlogBean blogBean) {
        Blog blog = new Blog();
        blog.setTitle(blogBean.getTitle());
        blog.setContent(blogBean.getContent());
//        blog.setTags(blogBean.getTags());

        Tag tag = tagRepository.findOne(blogBean.getTags().get(0).getId());
        // must use this function
        // otherwise, cannot save the manytomany side --- tags
        blog.addTag(tag);

        //have to set data by controller, since base domain event listener only works on generated rest
        blog.setCreatedate(new Date());
        blogRepository.save(blog);

        return "save success";
    }

    @RequestMapping(method = RequestMethod.GET, produces = { "application/json" })
    public @ResponseBody
    ResponseEntity<List<Blog>> getBlog() {
        List<Blog> blogList = blogRepository.findTop5ByOrderByCreatedateDesc();
        return new ResponseEntity<List<Blog>>(blogList, HttpStatus.OK);
    }

}

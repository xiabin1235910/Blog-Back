/**
 * Created by Ben on 8/26/2016.
 */

package com.ben.domain.web.controller;

import com.ben.domain.jpa.entity.blog.Blog;
import com.ben.domain.jpa.entity.tag.Tag;
import com.ben.domain.jpa.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tags")
public class TagController {

    @Autowired
    TagRepository tagRepository;

    @RequestMapping(method = RequestMethod.GET, produces = { "application/json" })
    public @ResponseBody
    ResponseEntity<List<Tag>> getTags() {
        List<Tag> tagList = tagRepository.findAll();
        return new ResponseEntity<List<Tag>>(tagList, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = { "application/json" })
    public @ResponseBody
    Tag getTagById(@PathVariable("id") Long id) {
        return tagRepository.getOne(id);
    }


    @RequestMapping(value = "{id}/blogs", method = RequestMethod.GET, produces = { "application/json" })
    public @ResponseBody
    List<Blog> getBlogsByTagId(@PathVariable("id") Long id) {
        return tagRepository.getOne(id).getBlogs();
    }
}

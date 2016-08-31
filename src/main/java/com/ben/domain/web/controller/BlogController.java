/**
 * Created by Ben on 8/26/2016.
 */

package com.ben.domain.web.controller;

import com.ben.domain.jpa.repository.BlogRepository;
import com.ben.domain.web.bean.BlogBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blog")
public class BlogController {

    @Autowired
    BlogRepository blogRepository;

    @RequestMapping(value = "/")
    public String saveBlog(@RequestBody BlogBean blogBean) {
        return "save success";
    }

}

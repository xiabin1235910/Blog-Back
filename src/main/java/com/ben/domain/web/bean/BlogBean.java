package com.ben.domain.web.bean;

import com.ben.domain.jpa.entity.tag.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben on 8/30/2016.
 */
public class BlogBean {

    private String title;

    private String content;

    private List<Tag> tags = new ArrayList<Tag>();

}

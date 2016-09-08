/**
 * Created by Ben on 8/29/2016.
 */
package com.ben.domain.jpa.repository;

import com.ben.domain.jpa.entity.account.User;
import com.ben.domain.jpa.entity.blog.Blog;
import com.ben.domain.jpa.entity.tag.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    Page<Blog> findByUser(@Param("user") User user, Pageable pageable);

    List<Blog> findByUser(@Param("user") User user);

    Page<Blog> findByTags(Tag tag, Pageable pageable);

    List<Blog> findTop5ByUser(@Param("user") User user, Sort sort);

    List<Blog> findTop5ByOrderByCreatedateDesc();
}

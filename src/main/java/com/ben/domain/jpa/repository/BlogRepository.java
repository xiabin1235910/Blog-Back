/**
 * Created by Ben on 8/29/2016.
 */
package com.ben.domain.jpa.repository;

import com.ben.domain.jpa.entity.account.User;
import com.ben.domain.jpa.entity.blog.Blog;
import com.ben.domain.jpa.entity.tag.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    Page<BlogRepository> findByUser(@Param("user") User user, Pageable pageable);

    List<BlogRepository> findByUser(@Param("user") User user);

    Page<BlogRepository> findByTags(Tag tag, Pageable pageable);
}

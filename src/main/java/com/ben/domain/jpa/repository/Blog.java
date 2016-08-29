/**
 * Created by Ben on 8/29/2016.
 */
package com.ben.domain.jpa.repository;

import com.ben.domain.jpa.entity.account.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Blog extends JpaRepository<Blog, Long> {
    Page<Blog> findByUser(@Param("user") User user, Pageable pageable);

}

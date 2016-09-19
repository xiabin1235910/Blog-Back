package com.ben.domain.jpa.repository;

import com.ben.domain.jpa.entity.tag.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ben on 9/19/2016.
 */
public interface TagRepository extends JpaRepository<Tag, Long>{

}

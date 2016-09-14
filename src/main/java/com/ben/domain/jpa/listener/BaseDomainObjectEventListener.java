package com.ben.domain.jpa.listener;

import com.ben.domain.jpa.entity.BaseDomainObject;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;

import java.util.Date;

/**
 * Created by Ben on 9/8/2016.
 */
public class BaseDomainObjectEventListener extends AbstractRepositoryEventListener<BaseDomainObject> {

    @Override
    protected void onBeforeCreate(BaseDomainObject entity) {
        System.out.println("insert create date");

        entity.setCreatedate(new Date());
    }

    @Override
    protected void onBeforeSave(BaseDomainObject entity) {
        entity.setModifieddate(new Date());
    }
}

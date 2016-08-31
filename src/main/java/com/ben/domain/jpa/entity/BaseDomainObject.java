/**
 * Created by Ben on 8/26/2016.
 */

package com.ben.domain.jpa.entity;

import com.ben.domain.jpa.entity.constants.Status;
import org.springframework.hateoas.Identifiable;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class BaseDomainObject implements Identifiable<Long> {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private Status status = Status.Active;

    private Date createdate;

    private Long creator;

    private Date modifieddate;

    private Long modifier;

    private Long optlock;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Date getModifieddate() {
        return modifieddate;
    }

    public void setModifieddate(Date modifieddate) {
        this.modifieddate = modifieddate;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Long getOptlock() {
        return optlock;
    }

    public void setOptlock(Long optlock) {
        this.optlock = optlock;
    }
}

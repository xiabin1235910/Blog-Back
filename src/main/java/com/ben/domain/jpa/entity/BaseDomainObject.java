/**
 * Created by Ben on 8/26/2016.
 */

package com.ben.domain.jpa.entity;

import com.ben.domain.jpa.entity.constants.Status;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class BaseDomainObject {

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
}

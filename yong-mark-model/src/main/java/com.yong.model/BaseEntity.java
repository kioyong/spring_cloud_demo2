package com.yong.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author LiangYong
 * @date 2017/12/24
 */
@Getter
@Setter
@ToString
public abstract class BaseEntity implements HasId {

    private String CreatedBy,LastModifiedBy;
    private Date CreatedDate,LastModifiedDate;

}

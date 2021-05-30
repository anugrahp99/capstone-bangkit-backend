package com.bangkit.yubisayu.botani.model.entity.base;

import com.bangkit.yubisayu.botani.constant.BaseEntityConstant;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;

import java.time.Instant;
import java.util.Date;


@Data
public class BaseEntity {

    @Column(BaseEntityConstant.CREATED_AT)
    @CreatedDate
    private Instant createdAt;

    @Column(BaseEntityConstant.UPDATED_AT)
    @LastModifiedDate
    private Instant updatedAt;

    @Column(BaseEntityConstant.DELETED)
    private int deleted;
}

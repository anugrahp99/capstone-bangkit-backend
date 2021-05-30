package com.bangkit.yubisayu.botani.model.entity.auth;

import com.bangkit.yubisayu.botani.model.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Token extends BaseEntity {

    private String access;

    private String refresh;
}

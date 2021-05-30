package com.bangkit.yubisayu.botani.model.entity.user;

import com.bangkit.yubisayu.botani.constant.BaseEntityConstant;
import com.bangkit.yubisayu.botani.constant.UserConstant;
//import com.bangkit.yubisayu.botani.model.entity.base.BaseEntity;
import com.bangkit.yubisayu.botani.model.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(UserConstant.USERS)
public class User extends BaseEntity implements Persistable<String>{
    @Id
    @Column(BaseEntityConstant.ID)
    private String id;

    @Column(UserConstant.FULLNAME)
    private String fullname;

    @Column(UserConstant.EMAIL)
    private String email;

    @Column(UserConstant.PROFILE_PICTURE)
    private String image;

    @Column(UserConstant.ADDRESS)
    private String address;

    @Column(UserConstant.CITY)
    private String city;

    @Column(UserConstant.PASSWORD)
    private String password;

    @Column(UserConstant.SEX)
    private int sex;

    @Column(UserConstant.ROLE)
    private String role;

    @Transient
    private boolean newObject=true;

    @Override
    @Transient
    public boolean isNew() {
        return this.newObject || id == null;
    }

    public User setAsNew(){
        this.newObject = true;
        return this;
    }


}



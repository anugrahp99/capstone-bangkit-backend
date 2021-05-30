package com.bangkit.yubisayu.botani.payload.response.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private String id;

    private String fullname;

    private String image;

    private int sex;

    private String address;

    private String city;

    private String role;
    private Instant createdAt;

    private Instant updatedAt;

    private int deleted;
}

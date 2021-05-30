package com.bangkit.yubisayu.botani.payload.request.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {

    @NotBlank
    private String fullname;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    private String image;

    @PositiveOrZero
    private int sex;

    @NotBlank
    private String address;

    @NotBlank
    private String city;

    private String role;
}

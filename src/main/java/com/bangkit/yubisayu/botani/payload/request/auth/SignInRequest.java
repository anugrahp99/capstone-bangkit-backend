package com.bangkit.yubisayu.botani.payload.request.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignInRequest {

    @NotBlank
    @Email(message = "InvalidFormat")
    private String username;

    @NotBlank
    private String password;
    
    private String role;
}

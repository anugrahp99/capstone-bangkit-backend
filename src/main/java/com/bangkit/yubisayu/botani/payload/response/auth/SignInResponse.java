package com.bangkit.yubisayu.botani.payload.response.auth;

import com.bangkit.yubisayu.botani.model.entity.auth.Token;
import com.bangkit.yubisayu.botani.payload.response.user.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignInResponse {

    private Token token;

    private UserResponse user;
}

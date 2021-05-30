package com.bangkit.yubisayu.botani.command.auth;


import com.blibli.oss.command.Command;
import com.bangkit.yubisayu.botani.payload.request.auth.SignUpRequest;
import com.bangkit.yubisayu.botani.payload.response.user.UserResponse;

public interface SignUpCommand extends
        Command<SignUpRequest, UserResponse> {
}

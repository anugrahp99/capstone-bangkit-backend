package com.bangkit.yubisayu.botani.command.auth;


import com.blibli.oss.command.Command;
import com.bangkit.yubisayu.botani.payload.request.auth.SignInRequest;
import com.bangkit.yubisayu.botani.payload.response.auth.SignInResponse;

public interface SignInCommand extends Command<SignInRequest, SignInResponse> {
}

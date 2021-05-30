package com.bangkit.yubisayu.botani.command.auth;

import com.blibli.oss.command.Command;
import com.bangkit.yubisayu.botani.payload.request.auth.RefreshTokenRequest;
import com.bangkit.yubisayu.botani.payload.response.auth.TokenResponse;

public interface RefreshTokenCommand extends
        Command<RefreshTokenRequest, TokenResponse> {
}

package com.bangkit.yubisayu.botani.controller;

import com.bangkit.yubisayu.botani.command.auth.RefreshTokenCommand;
import com.bangkit.yubisayu.botani.command.auth.SignInCommand;
import com.bangkit.yubisayu.botani.command.auth.SignUpCommand;
import com.bangkit.yubisayu.botani.constant.ApiPath;
import com.bangkit.yubisayu.botani.payload.request.auth.RefreshTokenRequest;
import com.bangkit.yubisayu.botani.payload.request.auth.SignInRequest;
import com.bangkit.yubisayu.botani.payload.request.auth.SignUpRequest;
import com.bangkit.yubisayu.botani.payload.response.auth.SignInResponse;
import com.bangkit.yubisayu.botani.payload.response.auth.TokenResponse;
import com.bangkit.yubisayu.botani.payload.response.user.UserResponse;
import com.blibli.oss.command.CommandExecutor;
import com.blibli.oss.common.response.Response;
import com.blibli.oss.common.response.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
public class AuthenticationController {

    @Autowired
    private CommandExecutor commandExecutor;

    @PostMapping(value = ApiPath.USER_REFRESH_TOKEN,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Response<TokenResponse>> refreshToken(
            @RequestBody RefreshTokenRequest refreshTokenRequest
    ) {
        return commandExecutor.execute(RefreshTokenCommand.class, refreshTokenRequest)
                .map(ResponseHelper::ok)
                .subscribeOn(Schedulers.boundedElastic());
    }

    @PostMapping(value = ApiPath.USER_SIGN_IN,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Response<SignInResponse>> signIn(
            @RequestBody SignInRequest signInRequest
    ) {
        return commandExecutor.execute(SignInCommand.class, signInRequest)
                .map(ResponseHelper::ok)
                .subscribeOn(Schedulers.boundedElastic());
    }

    @PostMapping(value = ApiPath.USER_SIGN_UP,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Response<UserResponse>> signUp(@RequestBody SignUpRequest signUpRequest) {
        return commandExecutor.execute(SignUpCommand.class, signUpRequest)
                .map(ResponseHelper::ok)
                .subscribeOn(Schedulers.boundedElastic());
    }
}

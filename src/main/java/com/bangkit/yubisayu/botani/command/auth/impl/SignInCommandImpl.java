package com.bangkit.yubisayu.botani.command.auth.impl;

import com.bangkit.yubisayu.botani.command.auth.SignInCommand;
import com.bangkit.yubisayu.botani.component.CustomPasswordEncoder;
import com.bangkit.yubisayu.botani.component.JwtTokenProvider;
import com.bangkit.yubisayu.botani.exception.UnauthorizedException;
import com.bangkit.yubisayu.botani.model.entity.auth.Token;
import com.bangkit.yubisayu.botani.model.entity.user.User;
import com.bangkit.yubisayu.botani.payload.request.auth.SignInRequest;
import com.bangkit.yubisayu.botani.payload.response.auth.SignInResponse;
import com.bangkit.yubisayu.botani.payload.response.user.UserResponse;
import com.bangkit.yubisayu.botani.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class SignInCommandImpl implements SignInCommand {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomPasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public Mono<SignInResponse> execute(SignInRequest request) {
        return findByUsername(request.getUsername()).map(user -> {
            if (isDataValid(request, user)) {
                Token token = getToken(
                        jwtTokenProvider.generateAccessToken(user),
                        jwtTokenProvider.generateRefreshToken(user)
                );
                return createResponse(token, user);
            }
            throw new UnauthorizedException();
        });
    }

    private Mono<User> findByUsername(String username) {
        return userRepository.findByEmail(username)
                .switchIfEmpty(Mono.error(UnauthorizedException::new));
    }

    private boolean isDataValid(SignInRequest request, User user) {
        return passwordEncoder.encode(request.getPassword()).equals(user.getPassword())
                && request.getRole().equals(user.getRole());
    }

    private Token getToken(String access, String refresh) {
        return Token.builder()
                .access(access)
                .refresh(refresh)
                .build();
    }

    private UserResponse getUser(User user) {
        UserResponse response = UserResponse.builder().build();
        BeanUtils.copyProperties(user, response);
        return response;
    }

    private SignInResponse createResponse(Token token, User user) {
        return SignInResponse.builder()
                .token(token)
                .user(getUser(user))
                .build();
    }
}

package com.bangkit.yubisayu.botani.command.auth.impl;


import com.bangkit.yubisayu.botani.command.auth.RefreshTokenCommand;
import com.bangkit.yubisayu.botani.component.JwtTokenProvider;
import com.bangkit.yubisayu.botani.model.entity.auth.Token;
import com.bangkit.yubisayu.botani.model.entity.user.User;
import com.bangkit.yubisayu.botani.payload.request.auth.RefreshTokenRequest;
import com.bangkit.yubisayu.botani.payload.response.auth.TokenResponse;
import com.bangkit.yubisayu.botani.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class RefreshTokenCommandImpl implements RefreshTokenCommand {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    public Mono<TokenResponse> execute(RefreshTokenRequest request) {
        return getUserById(request.getRefreshToken()).map(user -> {
            Token token = getToken(
                    jwtTokenProvider.generateAccessToken(user),
                    jwtTokenProvider.generateRefreshToken(user)
            );
            return createResponse(token);
        }).onErrorReturn(createResponse(null));
    }

    private Mono<User> getUserById(String token) {
        String userId = jwtTokenProvider.getUserIdFromToken(token);
        return userRepository.findById(userId);
    }

    private Token getToken(String access, String refresh) {
        return Token.builder()
                .access(access)
                .refresh(refresh)
                .build();
    }

    private TokenResponse createResponse(Token token) {
        return TokenResponse.builder()
                .token(token)
                .build();
    }
}

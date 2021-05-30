package com.bangkit.yubisayu.botani.command.auth.impl;

import com.bangkit.yubisayu.botani.command.auth.SignUpCommand;
import com.bangkit.yubisayu.botani.component.CustomPasswordEncoder;
import com.bangkit.yubisayu.botani.model.entity.user.User;
import com.bangkit.yubisayu.botani.payload.request.auth.SignUpRequest;
import com.bangkit.yubisayu.botani.payload.response.user.UserResponse;
import com.bangkit.yubisayu.botani.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class SignUpCommandImpl implements SignUpCommand {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomPasswordEncoder passwordEncoder;

    @Override
    public Mono<UserResponse> execute(SignUpRequest request) {
        return Mono.fromCallable(() -> createUser(request))
                .flatMap(user -> userRepository.save(user.setAsNew()))
                .map(this::createResponse);
    }

    private User createUser(SignUpRequest signUpRequest) {
        User user = User.builder()
                .id(UUID.randomUUID().toString())
                .build();
        BeanUtils.copyProperties(signUpRequest, user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return user;
    }

    private UserResponse createResponse(User user) {
        UserResponse response = UserResponse.builder().build();
        BeanUtils.copyProperties(user, response);
        return response;
    }
}

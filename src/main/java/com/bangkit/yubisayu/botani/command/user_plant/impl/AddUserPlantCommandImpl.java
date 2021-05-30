package com.bangkit.yubisayu.botani.command.user_plant.impl;

import com.bangkit.yubisayu.botani.command.auth.SignUpCommand;
import com.bangkit.yubisayu.botani.command.user_plant.AddUserPlantCommand;
import com.bangkit.yubisayu.botani.component.CustomPasswordEncoder;
import com.bangkit.yubisayu.botani.model.entity.user.User;
import com.bangkit.yubisayu.botani.model.entity.user.UserPlant;
import com.bangkit.yubisayu.botani.payload.request.auth.SignUpRequest;
import com.bangkit.yubisayu.botani.payload.request.user_plant.AddUserPlantRequest;
import com.bangkit.yubisayu.botani.payload.response.user.UserResponse;
import com.bangkit.yubisayu.botani.payload.response.user_plant.UserPlantResponse;
import com.bangkit.yubisayu.botani.repository.UserPlantRepository;
import com.bangkit.yubisayu.botani.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * @author Anugrah Prasetia
 * @date 5/29/2021 6:49 PM
 */

@Service
public class AddUserPlantCommandImpl implements AddUserPlantCommand {

    @Autowired
    private UserPlantRepository userPlantRepository;

    @Override
    public Mono<UserPlantResponse> execute(AddUserPlantRequest request) {
        return Mono.fromCallable(() -> createUserPlant(request))
                .flatMap(user -> userPlantRepository.save(user.setAsNew()))
                .map(this::createResponse);
    }

    private UserPlant createUserPlant(AddUserPlantRequest request) {
        UserPlant userPlant = UserPlant.builder()
                .id(UUID.randomUUID().toString())
                .build();
        BeanUtils.copyProperties(request, userPlant);
        return userPlant;
    }

    private UserPlantResponse createResponse(UserPlant user) {
        UserPlantResponse response = UserPlantResponse.builder().build();
        BeanUtils.copyProperties(user, response);
        return response;
    }
}

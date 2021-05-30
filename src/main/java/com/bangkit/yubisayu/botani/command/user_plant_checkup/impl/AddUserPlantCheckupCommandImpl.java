package com.bangkit.yubisayu.botani.command.user_plant_checkup.impl;

import com.bangkit.yubisayu.botani.command.user_plant_checkup.AddUserPlantCheckupCommand;
import com.bangkit.yubisayu.botani.model.entity.user.UserPlantCheckup;
import com.bangkit.yubisayu.botani.payload.request.user_plant_checkup.AddUserPlantCheckupRequest;
import com.bangkit.yubisayu.botani.payload.response.user_plant_checkup.UserPlantCheckupResponse;
import com.bangkit.yubisayu.botani.repository.UserPlantCheckupRepository;
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
public class AddUserPlantCheckupCommandImpl implements AddUserPlantCheckupCommand {

    @Autowired
    private UserPlantCheckupRepository userPlantCheckupRepository;

    @Override
    public Mono<UserPlantCheckupResponse> execute(AddUserPlantCheckupRequest request) {
        return Mono.fromCallable(() -> createUserPlant(request))
                .flatMap(user -> userPlantCheckupRepository.save(user.setAsNew()))
                .map(this::createResponse);
    }

    private UserPlantCheckup createUserPlant(AddUserPlantCheckupRequest request) {
        UserPlantCheckup userPlant = UserPlantCheckup.builder()
                .id(UUID.randomUUID().toString())
                .build();
        BeanUtils.copyProperties(request, userPlant);
        return userPlant;
    }

    private UserPlantCheckupResponse createResponse(UserPlantCheckup user) {
        UserPlantCheckupResponse response = UserPlantCheckupResponse.builder().build();
        BeanUtils.copyProperties(user, response);
        return response;
    }
}

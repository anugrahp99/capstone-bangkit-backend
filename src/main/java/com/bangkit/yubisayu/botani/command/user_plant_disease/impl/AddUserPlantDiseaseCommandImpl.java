package com.bangkit.yubisayu.botani.command.user_plant_disease.impl;

import com.bangkit.yubisayu.botani.command.user_plant_disease.AddUserPlantDiseaseCommand;
import com.bangkit.yubisayu.botani.model.entity.user.UserPlantDisease;
import com.bangkit.yubisayu.botani.payload.request.user_plant_disease.AddUserPlantDiseaseRequest;
import com.bangkit.yubisayu.botani.payload.response.user_plant_disease.UserPlantDiseaseResponse;
import com.bangkit.yubisayu.botani.repository.UserPlantDiseaseRepository;
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
public class AddUserPlantDiseaseCommandImpl implements AddUserPlantDiseaseCommand {

    @Autowired
    private UserPlantDiseaseRepository userPlantDiseaseRepository;

    @Override
    public Mono<UserPlantDiseaseResponse> execute(AddUserPlantDiseaseRequest request) {
        return Mono.fromCallable(() -> createUserPlant(request))
                .flatMap(user -> userPlantDiseaseRepository.save(user.setAsNew()))
                .map(this::createResponse);
    }

    private UserPlantDisease createUserPlant(AddUserPlantDiseaseRequest request) {
        UserPlantDisease userPlant = UserPlantDisease.builder()
                .id(UUID.randomUUID().toString())
                .build();
        BeanUtils.copyProperties(request, userPlant);
        return userPlant;
    }

    private UserPlantDiseaseResponse createResponse(UserPlantDisease user) {
        UserPlantDiseaseResponse response = UserPlantDiseaseResponse.builder().build();
        BeanUtils.copyProperties(user, response);
        return response;
    }
}

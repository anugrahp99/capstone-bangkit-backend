package com.bangkit.yubisayu.botani.command.user_plant.impl;

import com.bangkit.yubisayu.botani.command.plant_disease.GetPlantDiseaseByIdCommand;
import com.bangkit.yubisayu.botani.command.user_plant.GetUserPlantByIdCommand;
import com.bangkit.yubisayu.botani.exception.NotFoundException;
import com.bangkit.yubisayu.botani.model.entity.plant.PlantDisease;
import com.bangkit.yubisayu.botani.model.entity.user.UserPlant;
import com.bangkit.yubisayu.botani.payload.request.user_plant.GetUserPlantRequest;
import com.bangkit.yubisayu.botani.payload.response.plant.PlantDiseaseResponse;
import com.bangkit.yubisayu.botani.payload.response.user_plant.UserPlantResponse;
import com.bangkit.yubisayu.botani.repository.PlantDiseaseRepository;
import com.bangkit.yubisayu.botani.repository.UserPlantRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author Anugrah Prasetia
 * @date 5/29/2021 6:48 PM
 */

@Service
public class GetUserPlantByIdCommandImpl implements GetUserPlantByIdCommand {

    @Autowired
    private UserPlantRepository userPlantRepository;

    @Override
    public Mono<UserPlantResponse> execute(GetUserPlantRequest request) {
        return findPlant(request).map(this::createResponse);
    }

    private Mono<UserPlant> findPlant(GetUserPlantRequest request) {
        return userPlantRepository.findById(request.getUserPlantId())
                .switchIfEmpty(Mono.error(NotFoundException::new));
    }

    private UserPlantResponse createResponse(UserPlant plant) {
        UserPlantResponse plantByIdResponse = UserPlantResponse.builder().build();
        BeanUtils.copyProperties(plant, plantByIdResponse);
        return plantByIdResponse;
    }
}

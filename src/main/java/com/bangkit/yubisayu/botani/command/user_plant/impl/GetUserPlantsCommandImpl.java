package com.bangkit.yubisayu.botani.command.user_plant.impl;

import com.bangkit.yubisayu.botani.command.plant_disease.GetPlantDiseasesCommand;
import com.bangkit.yubisayu.botani.command.user_plant.GetUserPlantsCommand;
import com.bangkit.yubisayu.botani.model.entity.plant.PlantDisease;
import com.bangkit.yubisayu.botani.model.entity.user.UserPlant;
import com.bangkit.yubisayu.botani.payload.response.plant.PlantDiseaseResponse;
import com.bangkit.yubisayu.botani.payload.response.user_plant.UserPlantResponse;
import com.bangkit.yubisayu.botani.repository.PlantDiseaseRepository;
import com.bangkit.yubisayu.botani.repository.UserPlantRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author Anugrah Prasetia
 * @date 5/29/2021 6:45 PM
 */
@Service
public class GetUserPlantsCommandImpl implements GetUserPlantsCommand {

    @Autowired
    private UserPlantRepository userPlantRepository;

    @Override
    public Mono<List<UserPlantResponse>> execute(String userId) {
        return getAllPlants(userId)
                .map(this::createResponse)
                .collectList();
    }

    private Flux<UserPlant> getAllPlants(String userId) {
        return userPlantRepository.findAllByUserId(userId)
                .switchIfEmpty(Flux.empty());
    }

    private UserPlantResponse createResponse(UserPlant plant) {
        UserPlantResponse response = UserPlantResponse.builder().build();
        BeanUtils.copyProperties(plant, response);
        return response;
    }

}
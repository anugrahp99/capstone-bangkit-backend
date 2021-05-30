package com.bangkit.yubisayu.botani.command.user_plant_disease.impl;


import com.bangkit.yubisayu.botani.command.user_plant_disease.GetUserPlantDiseasesCommand;
import com.bangkit.yubisayu.botani.model.entity.user.UserPlantCheckup;
import com.bangkit.yubisayu.botani.model.entity.user.UserPlantDisease;
import com.bangkit.yubisayu.botani.payload.response.user_plant_checkup.UserPlantCheckupResponse;
import com.bangkit.yubisayu.botani.payload.response.user_plant_disease.UserPlantDiseaseResponse;
import com.bangkit.yubisayu.botani.repository.UserPlantCheckupRepository;
import com.bangkit.yubisayu.botani.repository.UserPlantDiseaseRepository;
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
public class GetUserPlantDiseasesCommandImpl implements GetUserPlantDiseasesCommand {

    @Autowired
    private UserPlantDiseaseRepository userPlantDiseaseRepository;

    @Override
    public Mono<List<UserPlantDiseaseResponse>> execute(String userPlantDiseaseId) {
        return getAllPlants(userPlantDiseaseId)
                .map(this::createResponse)
                .collectList();
    }

    private Flux<UserPlantDisease> getAllPlants(String userPlantDiseaseId) {
        return userPlantDiseaseRepository.findAllByUserPlantId(userPlantDiseaseId)
                .switchIfEmpty(Flux.empty());
    }

    private UserPlantDiseaseResponse createResponse(UserPlantDisease plant) {
        UserPlantDiseaseResponse response = UserPlantDiseaseResponse.builder().build();
        BeanUtils.copyProperties(plant, response);
        return response;
    }

}
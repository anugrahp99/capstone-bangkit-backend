package com.bangkit.yubisayu.botani.command.user_plant_checkup.impl;


import com.bangkit.yubisayu.botani.command.user_plant_checkup.GetUserPlantCheckupsCommand;
import com.bangkit.yubisayu.botani.model.entity.user.UserPlantCheckup;
import com.bangkit.yubisayu.botani.payload.response.user_plant_checkup.UserPlantCheckupResponse;
import com.bangkit.yubisayu.botani.repository.UserPlantCheckupRepository;
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
public class GetUserPlantCheckupsCommandImpl implements GetUserPlantCheckupsCommand {

    @Autowired
    private UserPlantCheckupRepository userPlantCheckupRepository;

    @Override
    public Mono<List<UserPlantCheckupResponse>> execute(String userId) {
        return getAllPlants(userId)
                .map(this::createResponse)
                .collectList();
    }

    private Flux<UserPlantCheckup> getAllPlants(String plantId) {
        return userPlantCheckupRepository.findAllByUserPlantId(plantId)
                .switchIfEmpty(Flux.empty());
    }

    private UserPlantCheckupResponse createResponse(UserPlantCheckup plant) {
        UserPlantCheckupResponse response = UserPlantCheckupResponse.builder().build();
        BeanUtils.copyProperties(plant, response);
        return response;
    }

}
package com.bangkit.yubisayu.botani.command.plant.impl;

import com.bangkit.yubisayu.botani.command.plant.GetPlantByIdCommand;
import com.bangkit.yubisayu.botani.exception.NotFoundException;
import com.bangkit.yubisayu.botani.model.entity.plant.Plant;
import com.bangkit.yubisayu.botani.payload.response.plant.PlantResponse;
import com.bangkit.yubisayu.botani.repository.PlantRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author Anugrah Prasetia
 * @date 5/29/2021 3:33 PM
 */

@Service
public class GetPlantByIdCommandImpl implements GetPlantByIdCommand {

    @Autowired
    private PlantRepository plantRepository;

    @Override
    public Mono<PlantResponse> execute(String request) {
        return findPlant(request).map(this::createResponse);
    }

    private Mono<Plant> findPlant(String id) {
        return plantRepository.findById(id)
                .switchIfEmpty(Mono.error(NotFoundException::new));
    }

    private PlantResponse createResponse(Plant plant) {
        PlantResponse plantByIdResponse = PlantResponse.builder().build();
        BeanUtils.copyProperties(plant, plantByIdResponse);
        return plantByIdResponse;
    }
}

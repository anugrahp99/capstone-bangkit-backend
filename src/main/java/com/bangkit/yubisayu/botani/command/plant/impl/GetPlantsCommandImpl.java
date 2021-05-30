package com.bangkit.yubisayu.botani.command.plant.impl;

import com.bangkit.yubisayu.botani.command.plant.GetPlantsCommand;
import com.bangkit.yubisayu.botani.model.entity.plant.Plant;
import com.bangkit.yubisayu.botani.payload.response.plant.PlantResponse;
import com.bangkit.yubisayu.botani.repository.PlantRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author Anugrah Prasetia
 * @date 5/29/2021 3:11 PM
 */

@Service
public class GetPlantsCommandImpl implements GetPlantsCommand {

    @Autowired
    private PlantRepository plantRepository;

    @Override
    public Mono<List<PlantResponse>> execute(String request) {
        return getAllPlants()
                .map(this::createResponse)
                .collectList();
    }

    private Flux<Plant> getAllPlants() {
        return plantRepository.findAll()
                .switchIfEmpty(Flux.empty());
    }

    private PlantResponse createResponse(Plant plant) {
        PlantResponse response = PlantResponse.builder().build();
        BeanUtils.copyProperties(plant, response);
        return response;
    }
}

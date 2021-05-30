package com.bangkit.yubisayu.botani.command.plant_disease.impl;

import com.bangkit.yubisayu.botani.command.plant_disease.GetPlantDiseasesCommand;
import com.bangkit.yubisayu.botani.model.entity.plant.Plant;
import com.bangkit.yubisayu.botani.model.entity.plant.PlantDisease;
import com.bangkit.yubisayu.botani.payload.response.plant.PlantDiseaseResponse;
import com.bangkit.yubisayu.botani.payload.response.plant.PlantResponse;
import com.bangkit.yubisayu.botani.repository.PlantDiseaseRepository;
import com.bangkit.yubisayu.botani.repository.PlantRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author Anugrah Prasetia
 * @date 5/29/2021 6:10 PM
 */

@Service
public class GetPlantDiseasesCommandImpl implements GetPlantDiseasesCommand {

    @Autowired
    private PlantDiseaseRepository plantDiseaseRepository;

    @Override
    public Mono<List<PlantDiseaseResponse>> execute(String request) {
        return getAllPlants()
                .map(this::createResponse)
                .collectList();
    }

    private Flux<PlantDisease> getAllPlants() {
        return plantDiseaseRepository.findAll()
                .switchIfEmpty(Flux.empty());
    }

    private PlantDiseaseResponse createResponse(PlantDisease plant) {
        PlantDiseaseResponse response = PlantDiseaseResponse.builder().build();
        BeanUtils.copyProperties(plant, response);
        return response;
    }

}

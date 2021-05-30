package com.bangkit.yubisayu.botani.command.plant_disease.impl;


import com.bangkit.yubisayu.botani.command.plant_disease.GetPlantDiseaseByIdCommand;
import com.bangkit.yubisayu.botani.exception.NotFoundException;
import com.bangkit.yubisayu.botani.model.entity.plant.PlantDisease;
import com.bangkit.yubisayu.botani.payload.response.plant.PlantDiseaseResponse;
import com.bangkit.yubisayu.botani.repository.PlantDiseaseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author Anugrah Prasetia
 * @date 5/29/2021 3:33 PM
 */

@Service
public class GetPlantDiseaseByIdCommandImpl implements GetPlantDiseaseByIdCommand {

    @Autowired
    private PlantDiseaseRepository plantDiseaseRepository;

    @Override
    public Mono<PlantDiseaseResponse> execute(String request) {
        return findPlant(request).map(this::createResponse);
    }

    private Mono<PlantDisease> findPlant(String id) {
        return plantDiseaseRepository.findById(id)
                .switchIfEmpty(Mono.error(NotFoundException::new));
    }

    private PlantDiseaseResponse createResponse(PlantDisease plant) {
        PlantDiseaseResponse plantByIdResponse = PlantDiseaseResponse.builder().build();
        BeanUtils.copyProperties(plant, plantByIdResponse);
        return plantByIdResponse;
    }
}

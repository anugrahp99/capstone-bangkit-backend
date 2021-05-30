package com.bangkit.yubisayu.botani.command.user_plant_disease.impl;


import com.bangkit.yubisayu.botani.command.user_plant_disease.GetUserPlantDiseaseByIdCommand;
import com.bangkit.yubisayu.botani.exception.NotFoundException;
import com.bangkit.yubisayu.botani.model.entity.user.UserPlantDisease;
import com.bangkit.yubisayu.botani.payload.request.user_plant_disease.GetUserPlantDiseaseRequest;
import com.bangkit.yubisayu.botani.payload.response.user_plant_disease.UserPlantDiseaseResponse;
import com.bangkit.yubisayu.botani.repository.UserPlantDiseaseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author Anugrah Prasetia
 * @date 5/29/2021 6:48 PM
 */

@Service
public class GetUserPlantDiseaseByIdCommandImpl implements GetUserPlantDiseaseByIdCommand {

    @Autowired
    private UserPlantDiseaseRepository userPlantDiseaseRepository;

    @Override
    public Mono<UserPlantDiseaseResponse> execute(GetUserPlantDiseaseRequest request) {
        return findPlant(request).map(this::createResponse);
    }

    private Mono<UserPlantDisease> findPlant(GetUserPlantDiseaseRequest request) {
        return userPlantDiseaseRepository.findById(request.getUserPlantDiseasesId())
                .switchIfEmpty(Mono.error(NotFoundException::new));
    }

    private UserPlantDiseaseResponse createResponse(UserPlantDisease plant) {
        UserPlantDiseaseResponse response = UserPlantDiseaseResponse.builder().build();
        BeanUtils.copyProperties(plant, response);
        return response;
    }

}

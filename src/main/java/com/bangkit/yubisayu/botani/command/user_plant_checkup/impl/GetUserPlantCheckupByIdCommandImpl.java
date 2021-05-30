package com.bangkit.yubisayu.botani.command.user_plant_checkup.impl;


import com.bangkit.yubisayu.botani.command.user_plant_checkup.GetUserPlantCheckupByIdCommand;
import com.bangkit.yubisayu.botani.exception.NotFoundException;
import com.bangkit.yubisayu.botani.model.entity.user.UserPlantCheckup;
import com.bangkit.yubisayu.botani.payload.request.user_plant_checkup.AddUserPlantCheckupRequest;
import com.bangkit.yubisayu.botani.payload.request.user_plant_checkup.GetUserPlantCheckupRequest;
import com.bangkit.yubisayu.botani.payload.response.user_plant_checkup.UserPlantCheckupResponse;
import com.bangkit.yubisayu.botani.repository.UserPlantCheckupRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author Anugrah Prasetia
 * @date 5/29/2021 6:48 PM
 */

@Service
public class GetUserPlantCheckupByIdCommandImpl implements GetUserPlantCheckupByIdCommand {

    @Autowired
    private UserPlantCheckupRepository userPlantCheckupRepository;

    @Override
    public Mono<UserPlantCheckupResponse> execute(GetUserPlantCheckupRequest request) {
        return findPlant(request).map(this::createResponse);
    }

    private Mono<UserPlantCheckup> findPlant(GetUserPlantCheckupRequest request) {
        return userPlantCheckupRepository.findById(request.getUserPlantCheckupId())
                .switchIfEmpty(Mono.error(NotFoundException::new));
    }

    private UserPlantCheckupResponse createResponse(UserPlantCheckup plant) {
        UserPlantCheckupResponse response = UserPlantCheckupResponse.builder().build();
        BeanUtils.copyProperties(plant, response);
        return response;
    }

}

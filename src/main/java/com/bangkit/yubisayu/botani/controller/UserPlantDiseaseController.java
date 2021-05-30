package com.bangkit.yubisayu.botani.controller;

import com.bangkit.yubisayu.botani.command.user_plant.AddUserPlantCommand;
import com.bangkit.yubisayu.botani.command.user_plant.GetUserPlantByIdCommand;
import com.bangkit.yubisayu.botani.command.user_plant.GetUserPlantsCommand;
import com.bangkit.yubisayu.botani.command.user_plant_disease.AddUserPlantDiseaseCommand;
import com.bangkit.yubisayu.botani.command.user_plant_disease.GetUserPlantDiseaseByIdCommand;
import com.bangkit.yubisayu.botani.command.user_plant_disease.GetUserPlantDiseasesCommand;
import com.bangkit.yubisayu.botani.constant.ApiPath;
import com.bangkit.yubisayu.botani.payload.request.user_plant.AddUserPlantRequest;
import com.bangkit.yubisayu.botani.payload.request.user_plant.GetUserPlantRequest;
import com.bangkit.yubisayu.botani.payload.request.user_plant_disease.AddUserPlantDiseaseRequest;
import com.bangkit.yubisayu.botani.payload.request.user_plant_disease.GetUserPlantDiseaseRequest;
import com.bangkit.yubisayu.botani.payload.response.user_plant.UserPlantResponse;
import com.bangkit.yubisayu.botani.payload.response.user_plant_disease.UserPlantDiseaseResponse;
import com.blibli.oss.command.CommandExecutor;
import com.blibli.oss.common.response.Response;
import com.blibli.oss.common.response.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

/**
 * @author Anugrah Prasetia
 * @date 5/30/2021 4:54 AM
 */
@RestController
public class UserPlantDiseaseController {

    @Autowired
    private CommandExecutor commandExecutor;

    @GetMapping(ApiPath.USER_PLANT_DISEASE)
    public Mono<Response<List<UserPlantDiseaseResponse>>> getUserPlantdiseases(@PathVariable("userId") String userId,
                                                                               @PathVariable("userPlantId") String userPlantId) {
        return commandExecutor.execute(GetUserPlantDiseasesCommand.class, userPlantId)
                .map(ResponseHelper::ok)
                .subscribeOn(Schedulers.boundedElastic());
    }

    @PostMapping(ApiPath.USER_PLANT_DISEASE)
    public Mono<Response<UserPlantDiseaseResponse>> addUserPlants(@PathVariable("userId") String userId,
                                                                  @PathVariable("userPlantId") String userPlantId, @RequestBody
    AddUserPlantDiseaseRequest request) {
        return commandExecutor.execute(AddUserPlantDiseaseCommand.class, request)
                .map(ResponseHelper::ok)
                .subscribeOn(Schedulers.boundedElastic());
    }

    @GetMapping(ApiPath.USER_PLANT_DISEASE_ID)
    public Mono<Response<UserPlantDiseaseResponse>> getPlantById(
            @PathVariable("userId") String userId,
            @PathVariable("userPlantId") String userPlantId,
            @PathVariable("userPlantDiseaseId") String userPlantDiseaseId
    ) {
        GetUserPlantDiseaseRequest request = GetUserPlantDiseaseRequest.builder()
                .userId(userId)
                .userPlantId(userPlantId)
                .userPlantDiseasesId(userPlantDiseaseId)
                .build();
        return commandExecutor.execute(GetUserPlantDiseaseByIdCommand.class, request)
                .map(ResponseHelper::ok)
                .subscribeOn(Schedulers.boundedElastic());
    }
}
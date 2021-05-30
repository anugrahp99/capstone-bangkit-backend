package com.bangkit.yubisayu.botani.controller;

import com.bangkit.yubisayu.botani.command.plant.GetPlantByIdCommand;
import com.bangkit.yubisayu.botani.command.plant.GetPlantsCommand;
import com.bangkit.yubisayu.botani.command.user_plant.AddUserPlantCommand;
import com.bangkit.yubisayu.botani.command.user_plant.GetUserPlantByIdCommand;
import com.bangkit.yubisayu.botani.command.user_plant.GetUserPlantsCommand;
import com.bangkit.yubisayu.botani.constant.ApiPath;
import com.bangkit.yubisayu.botani.payload.request.user_plant.AddUserPlantRequest;
import com.bangkit.yubisayu.botani.payload.request.user_plant.GetUserPlantRequest;
import com.bangkit.yubisayu.botani.payload.response.plant.PlantResponse;
import com.bangkit.yubisayu.botani.payload.response.user_plant.UserPlantResponse;
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
 * @date 5/29/2021 6:54 PM
 */

@RestController
public class UserPlantController {

    @Autowired
    private CommandExecutor commandExecutor;

    @GetMapping(ApiPath.USER_PLANT)
    public Mono<Response<List<UserPlantResponse>>> getUserPlants(@PathVariable("userId") String userId) {
        return commandExecutor.execute(GetUserPlantsCommand.class, userId)
                .map(ResponseHelper::ok)
                .subscribeOn(Schedulers.boundedElastic());
    }

    @PostMapping(ApiPath.USER_PLANT)
    public Mono<Response<UserPlantResponse>> addUserPlants(@PathVariable("userId") String userId, @RequestBody AddUserPlantRequest request) {
        return commandExecutor.execute(AddUserPlantCommand.class, request)
                .map(ResponseHelper::ok)
                .subscribeOn(Schedulers.boundedElastic());
    }

    @GetMapping(ApiPath.USER_PLANT_ID)
    public Mono<Response<UserPlantResponse>> getPlantById(
            @PathVariable("userId") String userId,
            @PathVariable("userPlantId") String userPlantId
    ) {
        GetUserPlantRequest request = GetUserPlantRequest.builder()
                .userId(userId)
                .userPlantId(userPlantId)
                .build();
        return commandExecutor.execute(GetUserPlantByIdCommand.class, request)
                .map(ResponseHelper::ok)
                .subscribeOn(Schedulers.boundedElastic());
    }

}

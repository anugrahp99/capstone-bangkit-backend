package com.bangkit.yubisayu.botani.controller;

import com.bangkit.yubisayu.botani.command.user_plant_checkup.AddUserPlantCheckupCommand;
import com.bangkit.yubisayu.botani.command.user_plant_checkup.GetUserPlantCheckupByIdCommand;
import com.bangkit.yubisayu.botani.command.user_plant_checkup.GetUserPlantCheckupsCommand;
import com.bangkit.yubisayu.botani.constant.ApiPath;
import com.bangkit.yubisayu.botani.payload.request.user_plant_checkup.AddUserPlantCheckupRequest;
import com.bangkit.yubisayu.botani.payload.request.user_plant_checkup.GetUserPlantCheckupRequest;
import com.bangkit.yubisayu.botani.payload.response.user_plant_checkup.UserPlantCheckupResponse;
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
 * @date 5/30/2021 5:09 AM
 */
@RestController
public class UserPlantCheckupController {

    @Autowired
    private CommandExecutor commandExecutor;

    @GetMapping(ApiPath.USER_PLANT_CHECKUP)
    public Mono<Response<List<UserPlantCheckupResponse>>> getUserPlantdiseases(@PathVariable("userId") String userId,
                                                                               @PathVariable("userPlantId") String userPlantId) {
        return commandExecutor.execute(GetUserPlantCheckupsCommand.class, userPlantId)
                .map(ResponseHelper::ok)
                .subscribeOn(Schedulers.boundedElastic());
    }

    @PostMapping(ApiPath.USER_PLANT_CHECKUP)
    public Mono<Response<UserPlantCheckupResponse>> addUserPlants(@PathVariable("userId") String userId,
                                                                  @PathVariable("userPlantId") String userPlantId, @RequestBody
                                                                          AddUserPlantCheckupRequest request) {
        return commandExecutor.execute(AddUserPlantCheckupCommand.class, request)
                .map(ResponseHelper::ok)
                .subscribeOn(Schedulers.boundedElastic());
    }

    @GetMapping(ApiPath.USER_PLANT_CHECKUP_ID)
    public Mono<Response<UserPlantCheckupResponse>> getPlantById(
            @PathVariable("userId") String userId,
            @PathVariable("userPlantId") String userPlantId,
            @PathVariable("userPlantCheckupId") String userPlantCheckupId
    ) {
        GetUserPlantCheckupRequest request = GetUserPlantCheckupRequest.builder()
                .userId(userId)
                .userPlantId(userPlantId)
                .userPlantCheckupId(userPlantCheckupId)
                .build();
        return commandExecutor.execute(GetUserPlantCheckupByIdCommand.class, request)
                .map(ResponseHelper::ok)
                .subscribeOn(Schedulers.boundedElastic());
    }
}
package com.bangkit.yubisayu.botani.controller;

import com.bangkit.yubisayu.botani.command.plant.GetPlantByIdCommand;
import com.bangkit.yubisayu.botani.command.plant.GetPlantsCommand;
import com.bangkit.yubisayu.botani.constant.ApiPath;
import com.bangkit.yubisayu.botani.payload.request.plant.GetPlantsRequest;
import com.bangkit.yubisayu.botani.payload.response.plant.PlantResponse;
import com.blibli.oss.command.CommandExecutor;
import com.blibli.oss.common.response.Response;
import com.blibli.oss.common.response.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

/**
 * @author Anugrah Prasetia
 * @date 5/29/2021 3:43 PM
 */
@RestController
public class PlantController {

    @Autowired
    private CommandExecutor commandExecutor;

    @GetMapping(ApiPath.PLANTS)
    public Mono<Response<List<PlantResponse>>> getPlants() {
        String plant="plant";
        return commandExecutor.execute(GetPlantsCommand.class, plant)
                .map(ResponseHelper::ok)
                .subscribeOn(Schedulers.boundedElastic());
    }

    @GetMapping(ApiPath.PLANTS_ID)
    public Mono<Response<PlantResponse>> getPlantById(
            @PathVariable("plantId") String plantId
    ) {
        return commandExecutor.execute(GetPlantByIdCommand.class, plantId)
                .map(ResponseHelper::ok)
                .subscribeOn(Schedulers.boundedElastic());
    }
}

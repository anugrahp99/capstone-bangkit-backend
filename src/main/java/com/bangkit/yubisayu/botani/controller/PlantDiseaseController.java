package com.bangkit.yubisayu.botani.controller;

import com.bangkit.yubisayu.botani.command.plant.GetPlantByIdCommand;
import com.bangkit.yubisayu.botani.command.plant.GetPlantsCommand;
import com.bangkit.yubisayu.botani.command.plant_disease.GetPlantDiseaseByIdCommand;
import com.bangkit.yubisayu.botani.command.plant_disease.GetPlantDiseasesCommand;
import com.bangkit.yubisayu.botani.constant.ApiPath;
import com.bangkit.yubisayu.botani.payload.response.plant.PlantDiseaseResponse;
import com.bangkit.yubisayu.botani.payload.response.plant.PlantResponse;
import com.blibli.oss.command.CommandExecutor;
import com.blibli.oss.common.response.Response;
import com.blibli.oss.common.response.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

/**
 * @author Anugrah Prasetia
 * @date 5/29/2021 6:14 PM
 */

@RestController
public class PlantDiseaseController {

    @Autowired
    private CommandExecutor commandExecutor;

    @GetMapping(ApiPath.PLANT_DISEASE)
    public Mono<Response<List<PlantDiseaseResponse>>> getPlantDiseases() {
        String plant="plant";
        return commandExecutor.execute(GetPlantDiseasesCommand.class, plant)
                .map(ResponseHelper::ok)
                .subscribeOn(Schedulers.boundedElastic());
    }

    @GetMapping(ApiPath.PLANT_DISEASE_ID)
    public Mono<Response<PlantDiseaseResponse>> getPlantDiseaseById(
            @PathVariable("plantDiseaseId") String plantDiseaseId
    ) {
        return commandExecutor.execute(GetPlantDiseaseByIdCommand.class, plantDiseaseId)
                .map(ResponseHelper::ok)
                .subscribeOn(Schedulers.boundedElastic());
    }
}

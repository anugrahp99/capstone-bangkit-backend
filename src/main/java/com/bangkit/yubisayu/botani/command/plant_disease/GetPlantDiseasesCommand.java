package com.bangkit.yubisayu.botani.command.plant_disease;

import com.bangkit.yubisayu.botani.payload.response.plant.PlantDiseaseResponse;
import com.blibli.oss.command.Command;

import java.util.List;

/**
 * @author Anugrah Prasetia
 * @date 5/29/2021 6:09 PM
 */
public interface GetPlantDiseasesCommand extends Command<String, List<PlantDiseaseResponse>> {
}
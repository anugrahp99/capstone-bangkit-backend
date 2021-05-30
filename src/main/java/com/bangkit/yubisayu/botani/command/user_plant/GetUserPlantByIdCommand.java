package com.bangkit.yubisayu.botani.command.user_plant;

import com.bangkit.yubisayu.botani.payload.request.user_plant.GetUserPlantRequest;
import com.bangkit.yubisayu.botani.payload.response.plant.PlantDiseaseResponse;
import com.bangkit.yubisayu.botani.payload.response.user_plant.UserPlantResponse;
import com.blibli.oss.command.Command;

/**
 * @author Anugrah Prasetia
 * @date 5/29/2021 6:44 PM
 */
public interface GetUserPlantByIdCommand extends Command<GetUserPlantRequest, UserPlantResponse> {
}


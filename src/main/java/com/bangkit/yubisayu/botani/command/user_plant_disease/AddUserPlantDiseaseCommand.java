package com.bangkit.yubisayu.botani.command.user_plant_disease;

import com.bangkit.yubisayu.botani.payload.request.user_plant_checkup.AddUserPlantCheckupRequest;
import com.bangkit.yubisayu.botani.payload.request.user_plant_disease.AddUserPlantDiseaseRequest;
import com.bangkit.yubisayu.botani.payload.response.user_plant_checkup.UserPlantCheckupResponse;
import com.bangkit.yubisayu.botani.payload.response.user_plant_disease.UserPlantDiseaseResponse;
import com.blibli.oss.command.Command;

/**
 * @author Anugrah Prasetia
 * @date 5/30/2021 4:11 AM
 */
public interface AddUserPlantDiseaseCommand extends
        Command<AddUserPlantDiseaseRequest, UserPlantDiseaseResponse> {
}
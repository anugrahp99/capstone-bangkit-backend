package com.bangkit.yubisayu.botani.command.user_plant_disease;

import com.bangkit.yubisayu.botani.payload.response.user_plant_checkup.UserPlantCheckupResponse;
import com.bangkit.yubisayu.botani.payload.response.user_plant_disease.UserPlantDiseaseResponse;
import com.blibli.oss.command.Command;

import java.util.List;

/**
 * @author Anugrah Prasetia
 * @date 5/30/2021 4:08 AM
 */
public interface GetUserPlantDiseasesCommand extends Command<String, List<UserPlantDiseaseResponse>> {
}


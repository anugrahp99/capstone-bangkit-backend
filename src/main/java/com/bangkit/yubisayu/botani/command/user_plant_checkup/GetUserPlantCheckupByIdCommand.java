package com.bangkit.yubisayu.botani.command.user_plant_checkup;

import com.bangkit.yubisayu.botani.payload.request.user_plant_checkup.GetUserPlantCheckupRequest;
import com.bangkit.yubisayu.botani.payload.response.user_plant_checkup.UserPlantCheckupResponse;
import com.blibli.oss.command.Command;

/**
 * @author Anugrah Prasetia
 * @date 5/30/2021 4:10 AM
 */
public interface GetUserPlantCheckupByIdCommand extends 
        Command<GetUserPlantCheckupRequest, UserPlantCheckupResponse> {
}
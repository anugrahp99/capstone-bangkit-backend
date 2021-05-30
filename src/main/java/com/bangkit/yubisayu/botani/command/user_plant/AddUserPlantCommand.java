package com.bangkit.yubisayu.botani.command.user_plant;

import com.bangkit.yubisayu.botani.payload.request.user_plant.AddUserPlantRequest;
import com.bangkit.yubisayu.botani.payload.response.user_plant.UserPlantResponse;
import com.blibli.oss.command.Command;

/**
 * @author Anugrah Prasetia
 * @date 5/29/2021 6:43 PM
 */
public interface AddUserPlantCommand extends
        Command<AddUserPlantRequest, UserPlantResponse> {
}
package com.bangkit.yubisayu.botani.command.user_plant;

import com.bangkit.yubisayu.botani.payload.response.user_plant.UserPlantResponse;
import com.blibli.oss.command.Command;

import java.util.List;

/**
 * @author Anugrah Prasetia
 * @date 5/29/2021 6:44 PM
 */
public interface GetUserPlantsCommand extends Command<String, List<UserPlantResponse>> {
}

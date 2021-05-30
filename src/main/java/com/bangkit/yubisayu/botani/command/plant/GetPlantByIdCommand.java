package com.bangkit.yubisayu.botani.command.plant;

import com.bangkit.yubisayu.botani.payload.response.plant.PlantResponse;
import com.blibli.oss.command.Command;

/**
 * @author Anugrah Prasetia
 * @date 5/29/2021 3:09 PM
 */
public interface GetPlantByIdCommand extends Command<String, PlantResponse> {
}

package com.bangkit.yubisayu.botani.command.plant;

import com.bangkit.yubisayu.botani.payload.response.plant.PlantResponse;
import com.blibli.oss.command.Command;

import java.util.List;

/**
 * @author Anugrah Prasetia
 * @date 5/29/2021 3:06 PM
 */
public interface GetPlantsCommand extends Command<String, List<PlantResponse>> {
}

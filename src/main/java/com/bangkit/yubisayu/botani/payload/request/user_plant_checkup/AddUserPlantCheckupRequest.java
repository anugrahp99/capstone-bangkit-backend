package com.bangkit.yubisayu.botani.payload.request.user_plant_checkup;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

/**
 * @author Anugrah Prasetia
 * @date 5/30/2021 4:01 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddUserPlantCheckupRequest {
    @NotBlank
    private String userPlantId;
    @PositiveOrZero
    private Double userPlantHumidity;
    @PositiveOrZero
    private Double userPlantTemperature;
}

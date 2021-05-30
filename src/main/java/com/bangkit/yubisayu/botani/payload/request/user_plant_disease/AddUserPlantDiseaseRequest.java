package com.bangkit.yubisayu.botani.payload.request.user_plant_disease;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Anugrah Prasetia
 * @date 5/30/2021 4:29 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddUserPlantDiseaseRequest {
    private String userPlantId;
    private String plantDiseaseId;
}
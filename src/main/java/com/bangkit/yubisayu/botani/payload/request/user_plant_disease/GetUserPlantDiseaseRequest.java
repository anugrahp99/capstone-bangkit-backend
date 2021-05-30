package com.bangkit.yubisayu.botani.payload.request.user_plant_disease;

import com.bangkit.yubisayu.botani.model.entity.plant.PlantDisease;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Anugrah Prasetia
 * @date 5/30/2021 4:28 AM
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetUserPlantDiseaseRequest {
    private String userId;
    private String userPlantId;
    private String userPlantDiseasesId;
}

package com.bangkit.yubisayu.botani.payload.response.user_plant_checkup;

import com.bangkit.yubisayu.botani.constant.BaseEntityConstant;
import com.bangkit.yubisayu.botani.constant.UserPlantCheckupConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.Instant;

/**
 * @author Anugrah Prasetia
 * @date 5/29/2021 6:39 PM
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPlantCheckupResponse {

    private String id;

    private String userPlantId;

    private Double userPlantHumidity;

    private Double userPlantTemperature;

    private Double userPlantNitrogen;

    private Double userPlantPotassium;

    private Double userPlantPhosphorus;

    private Instant createdAt;

    private Instant updatedAt;

    private int deleted;
}

package com.bangkit.yubisayu.botani.payload.response.user_plant_disease;

import com.bangkit.yubisayu.botani.constant.BaseEntityConstant;
import com.bangkit.yubisayu.botani.constant.UserPlantDiseaseConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.Instant;

/**
 * @author Anugrah Prasetia
 * @date 5/30/2021 4:28 AM
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPlantDiseaseResponse {
    protected String id;
    private String userPlantId;
    private String plantDiseaseId;
    private Instant createdAt;

    private Instant updatedAt;

    private int deleted;
}

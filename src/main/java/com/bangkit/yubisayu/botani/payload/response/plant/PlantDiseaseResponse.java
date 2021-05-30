package com.bangkit.yubisayu.botani.payload.response.plant;

import com.bangkit.yubisayu.botani.constant.BaseEntityConstant;
import com.bangkit.yubisayu.botani.constant.PlantDiseaseConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;

import java.time.Instant;

/**
 * @author Anugrah Prasetia
 * @date 5/29/2021 2:57 PM
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlantDiseaseResponse {

    private String id;

    private String diseaseName;

    private String diseaseDetail;

    private String diseaseTreatment;

    private String diseaseTreatmentVid;

    private Instant createdAt;

    private Instant updatedAt;

    private int deleted;
}

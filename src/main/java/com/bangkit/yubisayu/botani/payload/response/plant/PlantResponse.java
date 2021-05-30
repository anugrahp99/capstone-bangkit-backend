package com.bangkit.yubisayu.botani.payload.response.plant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

/**
 * @author Anugrah Prasetia
 * @date 5/29/2021 2:56 PM
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlantResponse {
    private String id;
    private String plantName;
    private String plantClass;
    private String plantSpecies;
    private Double plantHumidity;
    private Double plantLight;
    private Double plantFertilizer;
    private Float price;
    private Float salesPrice;
    private String monthHarvest;
    private String plantPreparation;
    private Instant createdAt;

    private Instant updatedAt;

    private int deleted;
}

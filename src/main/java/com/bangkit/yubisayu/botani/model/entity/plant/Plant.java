package com.bangkit.yubisayu.botani.model.entity.plant;

import com.bangkit.yubisayu.botani.constant.BaseEntityConstant;
import com.bangkit.yubisayu.botani.constant.PlantConstant;
import com.bangkit.yubisayu.botani.model.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(PlantConstant.PLANTS)
public class Plant extends BaseEntity {
    @Id
    @Column(BaseEntityConstant.ID)
    private String id;

    @Column(PlantConstant.PLANT_NAME)
    private String plantName;

    @Column(PlantConstant.PLANT_CLASS)
    private String plantClass;

    @Column(PlantConstant.PLANT_SPECIES)
    private String plantSpecies;

    @Column(PlantConstant.PLANT_HUMIDITY)
    private Double plantHumidity;

    @Column(PlantConstant.PLANT_LIGHTING)
    private Double plantLight;

    @Column(PlantConstant.PLANT_FERTILIZER)
    private Double plantFertilizer;

    @Column(PlantConstant.PLANT_PRICE)
    private Float price;

    @Column(PlantConstant.PLANT_SALES_PRICE)
    private Float salesPrice;

    @Column(PlantConstant.PLANT_MONTH_HARVEST)
    private String monthHarvest;

    @Column(PlantConstant.PLANT_PREPARATION)
    private String plantPreparation;
}

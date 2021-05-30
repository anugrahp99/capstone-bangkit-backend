package com.bangkit.yubisayu.botani.model.entity.plant;

import com.bangkit.yubisayu.botani.constant.BaseEntityConstant;
import com.bangkit.yubisayu.botani.constant.PlantDiseaseConstant;
import com.bangkit.yubisayu.botani.model.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(PlantDiseaseConstant.PLANT_DISEASES)
public class PlantDisease extends BaseEntity implements Persistable<String> {

    @Id
    @Column(BaseEntityConstant.ID)
    private String id;

    @Column(PlantDiseaseConstant.DISEASE_NAME)
    private String diseaseName;

    @Column(PlantDiseaseConstant.DISEASE_DETAIL)
    private String diseaseDetail;

    @Column(PlantDiseaseConstant.DISEASE_TREATMENT)
    private String diseaseTreatment;

    @Column(PlantDiseaseConstant.DISEASE_TREATMENT_VIDEOS)
    private String diseaseTreatmentVid;

    @Transient
    private boolean newObject=true;

    @Override
    @Transient
    public boolean isNew() {
        return this.newObject || id == null;
    }

    public PlantDisease setAsNew(){
        this.newObject = true;
        return this;
    }
}

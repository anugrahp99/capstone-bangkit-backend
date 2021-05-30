package com.bangkit.yubisayu.botani.model.entity.user;

import com.bangkit.yubisayu.botani.constant.BaseEntityConstant;
import com.bangkit.yubisayu.botani.constant.UserPlantCheckupConstant;
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
@Table(UserPlantCheckupConstant.USER_PLANT_CHECKUPS)
public class UserPlantCheckup extends BaseEntity implements Persistable<String> {
    @Id
    @Column(BaseEntityConstant.ID)
    private String id;

    @Column(UserPlantCheckupConstant.USER_PLANT_ID)
    private String userPlantId;

    @Column(UserPlantCheckupConstant.USER_PLANT_HUMIDITY)
    private Double userPlantHumidity;

    @Column(UserPlantCheckupConstant.USER_PLANT_TEMPERATURE)
    private Double userPlantTemperature;

    @Column(UserPlantCheckupConstant.USER_PLANT_NITROGEN)
    private Double userPlantNitrogen;

    @Column(UserPlantCheckupConstant.USER_PLANT_POTASSIUM)
    private Double userPlantPotassium;

    @Column(UserPlantCheckupConstant.USER_PLANT_PHOSPHORUS)
    private Double userPlantPhosphorus;

    @Transient
    private boolean newObject=true;

    @Override
    @Transient
    public boolean isNew() {
        return this.newObject || id == null;
    }

    public UserPlantCheckup setAsNew(){
        this.newObject = true;
        return this;
    }
}

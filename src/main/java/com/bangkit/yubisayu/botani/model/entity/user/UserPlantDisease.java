package com.bangkit.yubisayu.botani.model.entity.user;

import com.bangkit.yubisayu.botani.constant.BaseEntityConstant;
import com.bangkit.yubisayu.botani.constant.UserPlantDiseaseConstant;
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
@Table(UserPlantDiseaseConstant.USER_PLANT_DISEASES)
public class UserPlantDisease extends BaseEntity implements Persistable<String> {
    @Id
    @Column(BaseEntityConstant.ID)
    protected String id;

    @Column(UserPlantDiseaseConstant.USER_PLANT_ID)
    private String userPlantId;

    @Column(UserPlantDiseaseConstant.PLANT_DISEASES_ID)
    private String plantDiseaseId;

    @Transient
    private boolean newObject=true;

    @Override
    @Transient
    public boolean isNew() {
        return this.newObject || id == null;
    }

    public UserPlantDisease setAsNew(){
        this.newObject = true;
        return this;
    }
}

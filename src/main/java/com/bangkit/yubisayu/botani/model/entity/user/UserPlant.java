package com.bangkit.yubisayu.botani.model.entity.user;


import com.bangkit.yubisayu.botani.constant.BaseEntityConstant;
import com.bangkit.yubisayu.botani.constant.UserPlantConstant;
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
@Table(UserPlantConstant.USER_PLANTS)
public class UserPlant extends BaseEntity implements Persistable<String> {

    @Id
    @Column(BaseEntityConstant.ID)
    protected String id;

    @Column(UserPlantConstant.PLANT_ID)
    private String plantId;

    @Column(UserPlantConstant.USER_ID)
    private String userId;

    @Column(UserPlantConstant.USER_PLANT_NAME)
    private String plantName;

    @Column(UserPlantConstant.PLANT_HEALTH)
    private Double plantHealth;

    @Column(UserPlantConstant.PLANT_IMAGE)
    private String plantImg;

    @Column(UserPlantConstant.PLANT_DETAIL)
    private String plantDetail;

    @Column(UserPlantConstant.PLANT_PHASE)
    private String plantPhase;

    @Column(UserPlantConstant.PLANT_SUGGESTION)
    private String plantSuggest;

    @Transient
    private boolean newObject=true;

    @Override
    @Transient
    public boolean isNew() {
        return this.newObject || id == null;
    }

    public UserPlant setAsNew(){
        this.newObject = true;
        return this;
    }
}
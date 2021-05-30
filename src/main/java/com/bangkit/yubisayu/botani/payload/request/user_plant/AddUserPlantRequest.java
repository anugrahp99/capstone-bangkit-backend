package com.bangkit.yubisayu.botani.payload.request.user_plant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

/**
 * @author Anugrah Prasetia
 * @date 5/29/2021 6:33 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddUserPlantRequest {

    private String plantId;

    private String userId;

    private String plantName;

    @PositiveOrZero
    private Double plantHealth;

    private String plantImg;

    private String plantDetail;

    private String plantPhase;
    private String plantSuggest;

}

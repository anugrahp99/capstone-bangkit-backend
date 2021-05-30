package com.bangkit.yubisayu.botani.payload.request.user_plant_checkup;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author Anugrah Prasetia
 * @date 5/29/2021 7:03 PM
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetUserPlantCheckupRequest {
    @NotBlank
    private String userId;

    @NotBlank
    private String userPlantId;

    @NotBlank
    private String userPlantCheckupId;
}

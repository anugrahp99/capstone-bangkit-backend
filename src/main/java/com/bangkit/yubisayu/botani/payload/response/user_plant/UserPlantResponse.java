package com.bangkit.yubisayu.botani.payload.response.user_plant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

import java.time.Instant;

/**
 * @author Anugrah Prasetia
 * @date 5/29/2021 6:39 PM
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserPlantResponse {

    private String id;

    private String plantId;

    private String userId;

    private String plantName;

    private Double plantHealth;

    private String plantImg;

    private String plantDetail;

    private String plantPhase;

    private String plantSuggest;

    private Instant createdAt;

    private Instant updatedAt;

    private int deleted;

}

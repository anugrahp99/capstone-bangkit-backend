package com.bangkit.yubisayu.botani.payload.request.plant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Anugrah Prasetia
 * @date 5/29/2021 3:22 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetPlantsRequest {
    private int page;
    private int itemPerPage;
}
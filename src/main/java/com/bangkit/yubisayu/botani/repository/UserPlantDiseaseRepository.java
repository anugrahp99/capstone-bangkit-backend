package com.bangkit.yubisayu.botani.repository;

import com.bangkit.yubisayu.botani.model.entity.user.UserPlantCheckup;
import com.bangkit.yubisayu.botani.model.entity.user.UserPlantDisease;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Anugrah Prasetia
 * @date 5/30/2021 4:57 AM
 */
public interface UserPlantDiseaseRepository extends R2dbcRepository<UserPlantDisease, String> {
    Mono<UserPlantDisease> findById(String id);
    Flux<UserPlantDisease> findAllByUserPlantId(String userPlantId);
}

package com.bangkit.yubisayu.botani.repository;

import com.bangkit.yubisayu.botani.model.entity.user.UserPlant;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Anugrah Prasetia
 * @date 5/29/2021 6:40 PM
 */

@Repository
public interface UserPlantRepository extends R2dbcRepository<UserPlant, String> {
    Mono<UserPlant> findById(String id);
    Mono<UserPlant> findByPlantName(String plantName);
    Mono<UserPlant> existsByPlantName(String plantName);
    Flux<UserPlant> findAllByUserId(String userId);
}

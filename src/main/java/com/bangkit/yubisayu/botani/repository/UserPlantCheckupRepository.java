package com.bangkit.yubisayu.botani.repository;

import com.bangkit.yubisayu.botani.model.entity.user.UserPlant;
import com.bangkit.yubisayu.botani.model.entity.user.UserPlantCheckup;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Anugrah Prasetia
 * @date 5/30/2021 3:54 AM
 */
@Repository
public interface UserPlantCheckupRepository extends R2dbcRepository<UserPlantCheckup, String> {
    Mono<UserPlantCheckup> findById(String id);
    Flux<UserPlantCheckup> findAllByUserPlantId(String userPlantId);
}

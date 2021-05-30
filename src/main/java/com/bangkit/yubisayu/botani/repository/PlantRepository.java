package com.bangkit.yubisayu.botani.repository;

import com.bangkit.yubisayu.botani.model.entity.plant.Plant;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Anugrah Prasetia
 * @date 5/29/2021 2:59 PM
 */

@Repository
public interface PlantRepository extends R2dbcRepository<Plant, String> {
    Mono<Plant> findById(String id);
    Mono<Plant> findByPlantName(String plantName);
    Mono<Boolean> existsByPlantName(String plantName);
}

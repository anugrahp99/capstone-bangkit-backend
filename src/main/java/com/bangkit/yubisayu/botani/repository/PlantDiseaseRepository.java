package com.bangkit.yubisayu.botani.repository;

import com.bangkit.yubisayu.botani.model.entity.plant.PlantDisease;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Anugrah Prasetia
 * @date 5/29/2021 3:03 PM
 */

@Repository
public interface PlantDiseaseRepository extends R2dbcRepository<PlantDisease, String> {
    Mono<PlantDisease> findById(String id);
    Mono<PlantDisease> findByDiseaseName(String diseaseName);
    Mono<Boolean> existsByDiseaseName(String plantName);
}
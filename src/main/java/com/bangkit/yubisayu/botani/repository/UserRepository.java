package com.bangkit.yubisayu.botani.repository;

import com.bangkit.yubisayu.botani.model.entity.user.User;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends R2dbcRepository<User, String> {
    Mono<User> findById(String id);
    Mono<User> findByEmail(String email);
    Mono<User> findByIdAndRole(String id, String role);
    Mono<Boolean> existsByEmail(String email);
}

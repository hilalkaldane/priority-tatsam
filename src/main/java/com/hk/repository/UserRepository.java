package com.hk.repository;

import com.hk.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Hilal Kaldane
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}

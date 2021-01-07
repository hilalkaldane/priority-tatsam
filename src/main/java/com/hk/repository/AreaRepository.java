package com.hk.repository;

import com.hk.entity.AreaEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Hilal Kaldane
 */
@Repository
public interface AreaRepository extends JpaRepository<AreaEntity, Long> {
}

package com.upc.edu.pe.repository;

import com.upc.edu.pe.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion,Long> {
    Optional<Promotion> findByName(String name);
}

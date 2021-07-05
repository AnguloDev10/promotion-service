package com.upc.edu.pe.repository;

import com.upc.edu.pe.entity.Disccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisccountRepository extends JpaRepository<Disccount,Long> {
}

package com.gmtmarbles.backend.repository;

import java.math.BigDecimal;
import java.util.List;

import com.gmtmarbles.backend.entity.Slab;
import com.gmtmarbles.backend.entity.SlabStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlabRepository extends JpaRepository<Slab, Long> {

    List<Slab> findByStatus(SlabStatus status);

    List<Slab> findByMaterial(String material);

    List<Slab> findBySlabCode(String slabCode);

    List<Slab> findByPurchasePriceBetween(BigDecimal min, BigDecimal max);
}

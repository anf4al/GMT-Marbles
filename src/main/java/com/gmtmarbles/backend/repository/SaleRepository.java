package com.gmtmarbles.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmtmarbles.backend.entity.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
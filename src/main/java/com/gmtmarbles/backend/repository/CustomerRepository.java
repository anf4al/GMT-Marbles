package com.gmtmarbles.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmtmarbles.backend.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
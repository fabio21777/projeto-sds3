package com.fsm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsm.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}

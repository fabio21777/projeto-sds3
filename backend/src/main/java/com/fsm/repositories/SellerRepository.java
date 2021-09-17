package com.fsm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsm.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

}

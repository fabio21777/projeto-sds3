package com.fsm.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsm.dto.SellerDTO;
import com.fsm.entities.Seller;
import com.fsm.repositories.SellerRepository;

@Service
public class SellerService {
	@Autowired
	SellerRepository sellerRepository;
	
	public List<SellerDTO> findAll() {
		List<Seller> result = sellerRepository.findAll();
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}	

}

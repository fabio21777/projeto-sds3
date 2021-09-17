package com.fsm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fsm.dto.SellerDTO;
import com.fsm.entities.Seller;
import com.fsm.repositories.SellerRepository;

@Service
public class SellerService {
	@Autowired
	SellerRepository sellerRepository;

	@Transactional(readOnly = true)
	public Page<SellerDTO> findAll(PageRequest pageRequest) {
		
		Page<Seller> result = sellerRepository.findAll(pageRequest);
		return result.map(x -> new SellerDTO(x));
	}
	

}

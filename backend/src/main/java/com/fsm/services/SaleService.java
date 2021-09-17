package com.fsm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fsm.dto.SaleDTO;
import com.fsm.dto.SaleSuccessDTO;
import com.fsm.dto.SaleSumDTO;
import com.fsm.entities.Sale;
import com.fsm.repositories.SaleRepository;
import com.fsm.repositories.SellerRepository;

@Service
public class SaleService {
	@Autowired
	SaleRepository saleRepository;
	@Autowired
	SellerRepository sellerRepository;
	@Transactional
	public Page<SaleDTO> findAll(PageRequest pageRequest) {
		sellerRepository.findAll();
		Page<Sale> result = saleRepository.findAll(pageRequest);
		return result.map(x -> new SaleDTO(x));
	}
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller() {
		return saleRepository.amountGroupedBySeller();
	}

	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller() {
		return saleRepository.successGroupedBySeller();
	}

}

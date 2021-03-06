package com.fsm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fsm.dto.SaleDTO;
import com.fsm.dto.SaleSuccessDTO;
import com.fsm.dto.SaleSumDTO;
import com.fsm.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleControllers {
	@Autowired
	private SaleService service;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll (
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
			@RequestParam(value = "direction", defaultValue = "DESC") String direction) {
		PageRequest pageRequest = PageRequest.of(
				page,
				linesPerPage,
				Direction.valueOf(direction),
				orderBy);
		Page<SaleDTO> pages = service.findAll(pageRequest);
		return ResponseEntity.ok().body(pages);
		
	}
	
	@GetMapping(value = "/amount-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller() {
		List<SaleSumDTO> list = service.amountGroupedBySeller();
		return ResponseEntity.ok(list);
	}	
	
	@GetMapping(value = "/success-by-seller")
	public ResponseEntity<List<SaleSuccessDTO>>successGroupedBySeller(){
		List<SaleSuccessDTO>list = service.successGroupedBySeller();
		return ResponseEntity.ok(list);
	}
	
}

package com.fsm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fsm.dto.SellerDTO;
import com.fsm.services.SellerService;

@RestController
@RequestMapping(value = "/sellers")
public class SellerControllers {
	@Autowired
	private SellerService service;

	@GetMapping
	public ResponseEntity<Page<SellerDTO>> findAll (
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
			@RequestParam(value = "direction", defaultValue = "DESC") String direction) {
		PageRequest pageRequest = PageRequest.of(
				page,
				linesPerPage,
				Direction.valueOf(direction),
				orderBy);
		Page<SellerDTO> pages = service.findAll(pageRequest);
		return ResponseEntity.ok().body(pages);
		
	}
	
}

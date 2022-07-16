package com.devsuperior.dsmeta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	//Essa anotechion que faz essa importação automatica
	@Autowired
	private SaleService service;
	
	//Resposta via web usando Http
	@GetMapping
	public List<Sale> findSales() {
		return service.findSales();
		
	}
	
	

}

package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

//Registrando o Sale service como componente do sistema
@Service
public class SaleService {
	//Essa anotechion que faz essa importação automatica
	@Autowired
	private SaleRepository repository;
	
	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {
		
		//Definindo date se não for setada
		//Pegando o fusoHorario do sistema
		LocalDate today  = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		//Convenção da data de formato de texto para o formato do LocalDate
		LocalDate min = minDate.equals("") ? today.minusDays(365): LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
		
		
		return repository.findSales(min, max, pageable);
		
	}

}

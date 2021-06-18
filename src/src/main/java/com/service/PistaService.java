package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Pista;
import com.repository.PistaRepository;
import com.service.base.BaseService;

@Service
public class PistaService extends BaseService<Pista, Long, PistaRepository> {

	public PistaService(PistaRepository repo) {
		super(repo);
	}

	public List<Pista> pistasTipo(String tipo) {

		return this.repository.findByTipo(tipo);

	}
	
}
package com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Reserva;
import com.model.User;

	public interface ReservaRepository extends JpaRepository<Reserva, Long> {

		/*
		List<Reserva> findByUserContainsIgnoreCaseOrderByUserAsc(String nombre);
		 */
		
		
	}
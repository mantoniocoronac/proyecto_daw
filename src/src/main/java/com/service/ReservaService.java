package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Reserva;
import com.model.User;
import com.repository.ReservaRepository;
import com.repository.UserRepository;
import com.service.base.BaseService;

@Service
public class ReservaService extends BaseService<Reserva, Long, ReservaRepository> {
	
	@Autowired
	private ReservaRepository repository;
	
	@Autowired UserRepository urepo;
	
	public ReservaService(ReservaRepository repo) {
		super(repo);
	}

	public List<Reserva> findAll(){
		return repository.findAll();
	}
	
	public List<User> ufindAll(){
		return urepo.findAll();
	}
	
	public Reserva save(Reserva reserva){
		return repository.save(reserva);
	}

	public void eliminar(Long id) {
		urepo.deleteById(id);
	}
	
	/*public List<Reserva> reservasNombre(User user) {

		return this.repository.findByUserContainsIgnoreCaseOrderByUserAsc(user.getNombre());

	}*/

}
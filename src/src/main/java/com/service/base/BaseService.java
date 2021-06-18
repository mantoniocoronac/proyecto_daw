package com.service.base;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.User;

public abstract class BaseService<T, ID, R extends JpaRepository<T, ID>> implements IBaseService<T, ID> {

	protected R repository;

	public BaseService(R repo) {
		this.repository = repo;
	}

	@Override
	public T save(T t) {
		return repository.save(t);
	}

	@Override
	public T findById(ID id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<T> findAll() {
		return repository.findAll();
	}

	@Override
	public T edit(T t) {

		return repository.save(t);
	}

	@Override
	public void delete(T t) {
		repository.delete(t);
	}
	
	@Override
	public void deleteById(ID id) {
		repository.deleteById(id);
	}

}
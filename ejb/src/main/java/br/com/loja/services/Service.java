package br.com.loja.services;

import java.util.List;

import br.com.loja.models.AbstractModel;

public interface Service<T extends AbstractModel> {
	
	T get(Integer id);
	
	List<T> get();
	
	T save(T resource);
	
	T update(T resource, Integer id);
	
	void delete(Integer id);
	
}

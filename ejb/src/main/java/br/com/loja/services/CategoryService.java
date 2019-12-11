package br.com.loja.services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.loja.daos.CategoryDao;
import br.com.loja.daos.Dao;
import br.com.loja.models.CategoryModel;

@Stateless
public class CategoryService extends AbstractService<CategoryModel> {

	@Inject
	private CategoryDao dao;
	
	@Override
	protected Dao<CategoryModel> getDao() {
		return this.dao;
	}
	
	
	
}

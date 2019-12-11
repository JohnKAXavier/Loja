package br.com.loja.services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.loja.daos.Dao;
import br.com.loja.daos.ProductDao;
import br.com.loja.models.ProductModel;

@Stateless
public class ProductService extends AbstractService<ProductModel>{

	@Inject
	private ProductDao dao;
	
	@Override
	protected Dao<ProductModel> getDao() {
		return this.dao;
	}

}

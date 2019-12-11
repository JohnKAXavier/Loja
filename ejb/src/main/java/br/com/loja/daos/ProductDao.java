package br.com.loja.daos;

import javax.ejb.Stateless;

import br.com.loja.models.ProductModel;

@Stateless
public class ProductDao extends AbstractEntityManagerDao<ProductModel> {

	public ProductDao() {
		super(ProductModel.class);
	}

}

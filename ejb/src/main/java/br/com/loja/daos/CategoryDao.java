package br.com.loja.daos;

import javax.ejb.Stateless;

import br.com.loja.models.CategoryModel;

@Stateless
public class CategoryDao extends AbstractEntityManagerDao<CategoryModel>{

	public CategoryDao() {
		super(CategoryModel.class);
	}

}

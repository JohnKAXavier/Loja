package br.com.loja.controllers;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;

import br.com.loja.models.CategoryModel;
import br.com.loja.services.AbstractService;
import br.com.loja.services.CategoryService;

@WebServlet(urlPatterns = {"categories"})
public class CategoryController extends AbstractController<CategoryModel>{

	@Inject
	private CategoryService service;
	
	@Override
	protected AbstractService<CategoryModel> getService() {
		// TODO Auto-generated method stub
		return this.service;
	}

	@Override
	protected String getTitle(Boolean isListing) {
		// TODO Auto-generated method stub
		return isListing ? "Catgeorias" : "Categoria";
	}

	@Override
	protected String getResourceName() {
		// TODO Auto-generated method stub
		return "category";
	}

}

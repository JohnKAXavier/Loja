package br.com.loja.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.loja.models.CategoryModel;
import br.com.loja.models.ProductModel;
import br.com.loja.models.ShoppingCart;
import br.com.loja.services.AbstractService;
import br.com.loja.services.CategoryService;
import br.com.loja.services.ProductService;

@WebServlet(urlPatterns = {"products"})
public class ProductController extends AbstractController<ProductModel> {

	private final static String CATEGORY_PARAMETER_KEY = "category";
	
	@Inject
	private ShoppingCart shoppingCart;
	
	@Inject
	private ProductService service;
	
	@Inject
	private CategoryService categoryService;
	
	@Override
	protected AbstractService<ProductModel> getService() {
		return this.service;
	}
	
	@Override
	protected String getResourceName() {
		return "product";
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<CategoryModel> categories = this.categoryService.get();
		req.setAttribute("categories", categories);
		
		List<Integer> productsInCart = new ArrayList<Integer>();
		
		List<ProductModel> products = this.shoppingCart.getProducts();
		
		for(ProductModel product : products) 
		{
			productsInCart.add(product.getId());
		}
		
		req.setAttribute("productsInCart", productsInCart);
		
		super.doGet(req, resp);
	}

	@Override
	protected void populateResource(ProductModel resource, Map<String, String[]> parameterMap) {
		
		if(parameterMap.containsKey(CATEGORY_PARAMETER_KEY)) 
		{
			String categoryIdStr = parameterMap.get(CATEGORY_PARAMETER_KEY)[0];
			Integer categoryId = Integer.valueOf(categoryIdStr);
			
			CategoryModel categoryModel = this.categoryService.get(categoryId);
			
			resource.setCategory(categoryModel);
			
			parameterMap.remove(CATEGORY_PARAMETER_KEY);
		}
		
		super.populateResource(resource, parameterMap);
	}

	@Override
	protected String getTitle(Boolean isListing) {
		return isListing ? "Produtos" : "produto";
	}

	
	
}

package br.com.loja.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;

@Stateful
@SessionScoped
public class ShoppingCart {

	public ShoppingCart() {
		this.products = new ArrayList<ProductModel>();
	}
	
	private List<ProductModel> products;
	
	public List<ProductModel> getProducts()
	{
		List<ProductModel> auxiliar = new ArrayList<ProductModel>();
		
		auxiliar.addAll(this.products);
		
		return auxiliar;
	}
	
	public void add(ProductModel product)
	{
		this.products.add(product);
	}
	
	public void remove(Integer id) 
	{
		this.products.removeIf(prod -> prod.getId() == id);
	}
	
	public Double getTotal() 
	{
		return this.products.stream().mapToDouble(prod -> (double) prod.getPrice() ).sum();
	}
	
	public void clear() 
	{
		this.products.clear();
	}
}

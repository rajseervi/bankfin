package com.app.service;

import java.util.List;
 
import com.app.model.Product;


public interface IProductService {

	public int saveProduct(Product prod);
	public void updateProduct(Product prod);
	public void deleteProduct(int prodId); 
	public Product getProductById(int prodId);
	public List<Product> getAllProducts(); 
}

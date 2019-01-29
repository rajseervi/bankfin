package com.app.dao;

import java.util.List;
 
import com.app.model.Product;


public interface IProductDao {
	
	public int saveProduct(Product prod);
	public void updateProduct(Product prod);
	public void deleteProduct(int prodId); 
	public Product getProductById(int prodId);
	public List<Product> getAllProducts(); 

}

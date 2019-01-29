package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IProductDao;
import com.app.model.Product;
import com.app.service.IProductService;


@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductDao ob;
	
	@Transactional
	public int saveProduct(Product prod) {
		// TODO Auto-generated method stub
		return ob.saveProduct(prod);
	}

	@Transactional
	public void updateProduct(Product prod) {
		ob.updateProduct(prod);
	}

	@Transactional
	public void deleteProduct(int prodId) {
		// TODO Auto-generated method stub
		ob.deleteProduct(prodId);
	}

	@Transactional
	public Product getProductById(int prodId) {
		// TODO Auto-generated method stub
		return ob.getProductById(prodId);
	}

	@Transactional
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return ob.getAllProducts();
	}

}

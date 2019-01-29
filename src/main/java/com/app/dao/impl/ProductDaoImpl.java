package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IProductDao; 
import com.app.model.Product;

@Repository
public class ProductDaoImpl implements IProductDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public int saveProduct(Product prod) {
		// TODO Auto-generated method stub
		return (int) ht.save(prod);
	}

	@Override
	public void updateProduct(Product prod) {
		ht.update(prod);
	}

	@Override
	public void deleteProduct(int prodId) {
		ht.delete(new Product(prodId));
	}

	@Override
	public Product getProductById(int prodId) {
		// TODO Auto-generated method stub
		return ht.get(Product.class, prodId);
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return ht.loadAll(Product.class);
	}

}
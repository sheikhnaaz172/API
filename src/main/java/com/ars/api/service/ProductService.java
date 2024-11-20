package com.ars.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ars.api.exception.ResourceNotFoundException;
import com.ars.api.model.Product;
import com.ars.api.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;

	public Product createProduct(Product product) {
		return productRepo.save(product);
	}

	public List<Product> getAllProduct() {
		return productRepo.findAll();
	}

	public Product getProductById(Long id) throws ResourceNotFoundException {
		Product prdct = productRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product Not Found By the Id " + id));
		return prdct;

	}

	public void deleteProductById(Long id) {
		// TODO Auto-generated method stub
//		return 
		productRepo.deleteById(id);
//				orElseThrow(()->new ResourceNotFoundException("Id requested to delete not found"+ id));
	}

}

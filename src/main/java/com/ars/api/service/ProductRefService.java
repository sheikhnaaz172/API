package com.ars.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ars.api.exception.ResourceNotFoundException;
import com.ars.api.model.ProductRef;
import com.ars.api.repo.ProductRefRepo;
@Service
public class ProductRefService {
	
	@Autowired
	private ProductRefRepo productRefRepo;

	public ProductRef createProductRef(ProductRef productRef) {
		return productRefRepo.save(productRef);
	}
	
	public List<ProductRef> getAllProductRef(){
		return productRefRepo.findAll();
	}

	public ProductRef getProductRefById(Long id) throws ResourceNotFoundException {
		ProductRef prdct = productRefRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Product Not Found By the Id "+ id));
		return prdct;

	}

	public void deleteProductRefById(Long id) {
		// TODO Auto-generated method stub
//		return 
		productRefRepo.deleteById(id);
//				orElseThrow(()->new ResourceNotFoundException("Id requested to delete not found"+ id));
	}

}

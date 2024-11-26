package com.ars.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ars.api.exception.ResourceNotFoundException;
import com.ars.api.model.Product;
import com.ars.api.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	@Value(value = "${prdct.url}")
	private String url;

	public Product createProduct(Product product) {
		Product pr= productRepo.save(product);
		pr.setHref(url+pr.getId());
		pr.setProductId("PR"+pr.getQuantity()+pr.getId());
		return productRepo.save(pr);
	}

	public List<Product> getAllProduct() {
		return productRepo.findAll();
	}

	public Product getProductById(Long id) throws ResourceNotFoundException {
		Product prdct = productRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product Not Found By the Id " + id));
		return prdct;

	}
public String getProductHrefByName(String name) {
	String href=productRepo.getProductHrefByName(name);
	return href;
}
	public void deleteProductById(Long id) {
		// TODO Auto-generated method stub
//		return 
		productRepo.deleteById(id);
//				orElseThrow(()->new ResourceNotFoundException("Id requested to delete not found"+ id));
	}

}

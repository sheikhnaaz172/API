package com.ars.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ars.api.model.Product;

public interface ProductRepo extends JpaRepository<Product,Long>{

	@Query(value="select p.href from product  p where p.product_name=?1",nativeQuery=true )
	String getProductHrefByName(String name);

}

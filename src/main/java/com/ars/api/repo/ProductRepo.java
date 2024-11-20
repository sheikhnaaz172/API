package com.ars.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ars.api.model.Product;

public interface ProductRepo extends JpaRepository<Product,Long>{

}

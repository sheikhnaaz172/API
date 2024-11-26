package com.ars.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ars.api.model.Customer;
@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long>{

	@Query(value="select c.href from customer c where c.customer_id=?1",nativeQuery=true)
	String getHrefByCustomerId(String name);


}

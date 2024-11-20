package com.ars.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ars.api.model.Customer;
@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long>{

	@Query(value="select c.customer_id from customer c where c.name=?1",nativeQuery=true)
	String getCustomerIdByName(String name);


}

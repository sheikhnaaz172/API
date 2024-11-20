package com.ars.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ars.api.model.CustomerOrder;

public interface CustomerOrderRepo extends JpaRepository<CustomerOrder,Long>{

}

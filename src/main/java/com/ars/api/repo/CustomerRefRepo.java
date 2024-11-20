package com.ars.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ars.api.model.CustomerRef;

public interface CustomerRefRepo extends JpaRepository<CustomerRef,Long>{

}

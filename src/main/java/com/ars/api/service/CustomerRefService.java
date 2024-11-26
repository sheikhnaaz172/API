package com.ars.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ars.api.exception.ResourceNotFoundException;
import com.ars.api.model.CustomerRef;
import com.ars.api.repo.CustomerRefRepo;

@Service
public class CustomerRefService {

	@Autowired
	private CustomerRefRepo customerRefRepo;
	
	@Autowired
	private CustomerService customerService;

	public CustomerRef createCustomerRef(CustomerRef cust) {
		
		CustomerRef custRef=customerRefRepo.save(cust);
		custRef.setHref(customerService.getHrefByCustomerId(cust.getCustomerId()));
		
		return customerRefRepo.save(custRef);
	}

	public List<CustomerRef> getAllCustomerRef() {
		return customerRefRepo.findAll();
	}

	public CustomerRef getCustomerRefById(Long id) throws ResourceNotFoundException {
		CustomerRef customerRef = customerRefRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(" CustomerRef Details Not Found By the Id " + id));
		return customerRef;

	}

	public void deleteCustomerRefById(Long id) {
		// TODO Auto-generated method stub
//		return 
		customerRefRepo.deleteById(id);
//				orElseThrow(()->new ResourceNotFoundException("Id requested to delete not found"+ id));
	}

}

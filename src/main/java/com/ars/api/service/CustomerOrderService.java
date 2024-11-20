package com.ars.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ars.api.exception.ResourceNotFoundException;
import com.ars.api.model.CustomerOrder;
import com.ars.api.repo.CustomerOrderRepo;

@Service
public class CustomerOrderService {

	@Autowired
	private CustomerOrderRepo customerOrderRepo;

	public CustomerOrder createCustomerOrder(CustomerOrder customerOrder) {
		
		String customerId;
		CustomerOrder cs = customerOrderRepo.save(customerOrder);
//		cs.setOrderDate();
		return cs;

	}
	
	public List<CustomerOrder> getAllCustomerOrder(){
		return customerOrderRepo.findAll();
	}

	public CustomerOrder getCustomerById(Long id) throws ResourceNotFoundException {
		CustomerOrder order = customerOrderRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Order Not Found By the Id "+ id));
		return order;

	}

	public void deleteCustomerById(Long id) {
		// TODO Auto-generated method stub
//		return 
				customerOrderRepo.deleteById(id);
//				orElseThrow(()->new ResourceNotFoundException("Id requested to delete not found"+ id));
	}
	 
	

}

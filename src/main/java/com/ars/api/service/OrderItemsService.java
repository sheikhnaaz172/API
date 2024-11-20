package com.ars.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ars.api.exception.ResourceNotFoundException;
import com.ars.api.model.OrderItems;
import com.ars.api.repo.OrderItemsRepo;

@Service
public class OrderItemsService {

	@Autowired
	private OrderItemsRepo orderItemsRepo;

	public OrderItems createOrderItem(OrderItems orderItems) {
		return orderItemsRepo.save(orderItems);

	}

	public List<OrderItems> getAllOrderItem() {
		return orderItemsRepo.findAll();
	}

	public OrderItems getOrderItemById(Long id) throws ResourceNotFoundException {
		OrderItems order = orderItemsRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Order Not Found By the Id " + id));
		return order;

	}

	public void deleteOrderItemById(Long id) {
		// TODO Auto-generated method stub
//		return 
		orderItemsRepo.deleteById(id);
//				orElseThrow(()->new ResourceNotFoundException("Id requested to delete not found"+ id));
	}
}

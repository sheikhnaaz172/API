package com.ars.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ars.api.model.OrderItems;

public interface OrderItemsRepo extends JpaRepository<OrderItems,Long>{


}

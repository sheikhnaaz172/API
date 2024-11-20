package com.ars.api.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;	
import javax.persistence.Entity;				
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
				
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerOrder {
										
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String orderId;
	private Date orderDate;
	private Double totalCost;
	
	
	
//	String
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE,
			CascadeType.DETACH }, fetch = FetchType.EAGER)
	@JsonBackReference("customerOrder")
	private CustomerRef customerRef;
	
	@OneToMany(cascade={ CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE,
			CascadeType.DETACH }, fetch = FetchType.EAGER)
	@JsonManagedReference("orderItems")
	private List<OrderItems> orderItems;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	

}

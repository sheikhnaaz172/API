package com.ars.api.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItems {

	public OrderItems() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
//	private String orderItemId;

//	private Integer quantity;
//	private string unitPrice;
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference("productRef")
	private ProductRef productRef;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE,
			CascadeType.DETACH }, fetch = FetchType.EAGER)
	@JsonBackReference("orderItems")
	private CustomerOrder customerOrder;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}

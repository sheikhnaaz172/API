package com.ars.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerRef {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String customerId;
	
	private String href;
	
	@OneToMany(cascade= {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE,CascadeType.DETACH},fetch = FetchType.EAGER)
	@JsonManagedReference("customerOrder")
	private List<CustomerOrder> customerOrder;
	
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}
	
}

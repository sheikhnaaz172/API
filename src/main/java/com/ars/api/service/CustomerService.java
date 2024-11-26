package com.ars.api.service;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ars.api.exception.ResourceNotFoundException;
import com.ars.api.model.Customer;
import com.ars.api.repo.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo customerRepo;

	private EntityManager en;
	
	@Value(value = "${cust.url}")
	private String url;

	public Customer createCustomer(Customer cust)  {
//		DateTimeFormatter format= new DateTimeFormatter;

		/*
		 * Date curDate=customer.getDate(); DateTimeFormatter dtf=
		 * DateTimeFormatter.ofPattern(customer.getDate().toString());
		 */
		cust.setDate(LocalDate.now());
		cust.setCustomerId("CST"+cust.getFirstName().toUpperCase()+LocalDate.now().getDayOfMonth());
		
//		Customer customer = customerRepo.save(cust);
//        SimpleDateFormat inputFormat = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
//		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
//		 Date date = inputFormat.parse(customer.getDate().toString());
//		customer.setCustomerId(format.parse(customer.getDate().toString()).toString());
		Customer cs = customerRepo.save(cust);
		cs.setHref(url+cs.getId());
		cs.setName(cust.getFirstName()+" "+cust.getLastName());
		return customerRepo.save(cust);
	}

	public List<Customer> getAllCustomer() {
		return customerRepo.findAll();
	}

	public Customer getCustomerById(Long id) throws ResourceNotFoundException {
		Customer customer = customerRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(" Customer Details Not Found By the Id " + id));
		return customer;

	}

	public String getHrefByCustomerId(String customerId) {
		/*
		 * CriteriaBuilder cb= en.getCriteriaBuilder(); CriteriaQuery<Customer>
		 * cq=cb.createQuery(Customer.class); Root<Customer>
		 * customer=cq.from(Customer.class); Predicate predicate ;
		 * predicate=cb.like(customer.get(name), "%"+name+"%"); //
		 * cq.select(customer).where( cb.like(customer.get(name), "%"+name+"%"));
		 * cq.select(customer.get("CustomerId")).where(predicate);
		 */

//		return en.createQuery(cq).toString();

		String href = customerRepo.getHrefByCustomerId(customerId);
		return href;
	}

	public void deleteCustomerById(Long id) {
		// TODO Auto-generated method stub
//		return 
		customerRepo.deleteById(id);
//				orElseThrow(()->new ResourceNotFoundException("Id requested to delete not found"+ id));
	}

}

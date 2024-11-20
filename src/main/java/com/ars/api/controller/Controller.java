package com.ars.api.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ars.api.exception.ResourceNotFoundException;
import com.ars.api.model.Customer;
import com.ars.api.model.CustomerOrder;
import com.ars.api.model.OrderItems;
import com.ars.api.model.Product;
import com.ars.api.model.ProductRef;
import com.ars.api.service.CustomerOrderService;
import com.ars.api.service.CustomerService;
import com.ars.api.service.OrderItemsService;
import com.ars.api.service.ProductRefService;
import com.ars.api.service.ProductService;

@RestController
@RequestMapping(value = "api/", produces = MediaType.APPLICATION_JSON_VALUE)
public class Controller {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private CustomerOrderService customerOrderService;

	@Autowired
	private ProductRefService productRefService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderItemsService orderItemService;

	@PostMapping("createCustomer")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) throws ParseException {
		Customer cs = customerService.createCustomer(customer);
		return new ResponseEntity<>(cs, HttpStatus.CREATED);

	}

	@GetMapping("getAllCustomer")
	public List<Customer> getAllCustomer() {
		return customerService.getAllCustomer();
	}

	@GetMapping("customer/{id}")
	public ResponseEntity<Customer> getCustomerById(@RequestParam Long id) throws ResourceNotFoundException {
		Customer customer = customerService.getCustomerById(id);
//		return new ResponseEntity<>(,HttpStatus.FOUND);
		return ResponseEntity.status(HttpStatus.OK).body(customer);
	}

	@DeleteMapping("customer/{id}")
	public void deleteCustomerById(@RequestParam Long id) {
		customerService.deleteCustomerById(id);
	}
	
	@GetMapping("getCustomerIdByName/{customerName}")
	public String getCustomerIdByName(@RequestParam String customerName) {
		return customerService.getCustomerIdByName(customerName);
	}

	@PostMapping("createCustomerOrderr")
	public CustomerOrder createCustomerOrder(@RequestBody CustomerOrder customerOrder) {
		return customerOrderService.createCustomerOrder(customerOrder);

	}

	@GetMapping("customerOrder/{id}")
	public ResponseEntity<CustomerOrder> getCustomerOrderById(@RequestParam Long id) throws ResourceNotFoundException {
		CustomerOrder order = customerOrderService.getCustomerById(id);
//		return new ResponseEntity<>(order,HttpStatus.FOUND);
		return ResponseEntity.status(HttpStatus.OK).body(order);
	}

	@GetMapping("getAllCustomerOrder")
	public List<CustomerOrder> getAllCustomerOrder() {
		return customerOrderService.getAllCustomerOrder();
	}

	@DeleteMapping("customerOrder/{id}")
	public void deleteCustomerOrderById(@RequestParam Long id) {
		customerOrderService.deleteCustomerById(id);
	}
	
	@PostMapping("createProduct")
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);

	}

	@GetMapping("product/{id}")
	public ResponseEntity<Product> getProductById(@RequestParam Long id) throws ResourceNotFoundException {
		Product order = productService.getProductById(id);
//		return new ResponseEntity<>(order,HttpStatus.FOUND);
		return ResponseEntity.status(HttpStatus.OK).body(order);
	}

	@GetMapping("getAllProduct")
	public List<Product> getAllProduct() {
		return productService.getAllProduct();
	}

	@DeleteMapping("product/{id}")
	public void deleteProductById(@RequestParam Long id) {
		productService.deleteProductById(id);
	}
	
	@PostMapping("createOrderItems")
	public OrderItems createOrderItems(@RequestBody OrderItems orderItem) {
		return orderItemService.createOrderItem(orderItem);

	}

	@GetMapping("orderItem/{id}")
	public ResponseEntity<OrderItems> getOrderItemsById(@RequestParam Long id) throws ResourceNotFoundException {
		OrderItems order = orderItemService.getOrderItemById(id);
//		return new ResponseEntity<>(order,HttpStatus.FOUND);
		return ResponseEntity.status(HttpStatus.OK).body(order);
	}

	@GetMapping("getAllOrderItems")
	public List<OrderItems> getAllOrderItems() {
		return orderItemService.getAllOrderItem();
	}

	@DeleteMapping("orderItem/{id}")
	public void deleteOrderItemsById(@RequestParam Long id) {
		orderItemService.deleteOrderItemById(id);
	}

	@GetMapping("productRef/{id}")
	public ResponseEntity<ProductRef> getProductRefById(@RequestParam Long id) throws ResourceNotFoundException {
		ProductRef prdct = productRefService.getProductRefById(id);
//		return new ResponseEntity<>(order,HttpStatus.FOUND);
		return ResponseEntity.status(HttpStatus.OK).body(prdct);
	}

	@DeleteMapping("productRef/{id}")
	public void deleteProductRefById(@RequestParam Long id) {
		productRefService.deleteProductRefById(id);
	}
	

}

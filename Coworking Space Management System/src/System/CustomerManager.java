package System;

import java.util.ArrayList;
import java.util.UUID;

public class CustomerManager {
	private static final CustomerManager instance = new CustomerManager();
	private ArrayList<Customer> customerList;
	
	private CustomerManager() {
		this.customerList = new ArrayList<Customer>(); 
	} 
	
	public static CustomerManager getInstance() {
		return instance;
	}
	
	public Customer SearchCustomerById(UUID id) {
		for (Customer c : customerList) {
			if (c.getId().equals(id)) {
				return c;
			}
		}
		return null;
	}
	
	public Customer AddCustomer (String username, String password) {
		Customer newCustomer = new Customer(username, password);
		customerList.add(newCustomer);
		return newCustomer;
	}
}

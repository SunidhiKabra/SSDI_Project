package service;

import java.util.List;

import dao.CustomerDao;
import model.Customer;
import model.ICustomer;

public class CustomerService implements ICustomerService{

	private CustomerDao customer_dao;
	
	public CustomerService(CustomerDao customer_dao) {
		super();
		this.customer_dao = customer_dao;
	}

	@Override
	public void addCustomer(Customer customer) {
		customer_dao.addCustomer(customer);
		
	}

	@Override
	public List<Customer> getCustomers() {
		return customer_dao.getCustomer();
	}

}

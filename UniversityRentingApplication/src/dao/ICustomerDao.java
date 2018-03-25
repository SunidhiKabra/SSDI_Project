package dao;

import java.util.List;

import model.Customer;

public interface ICustomerDao {
	public void addCustomer(Customer customer);
	public List<Customer> getCustomer();
}

package dao;

import java.util.List;

import model.*;

public interface ICustomerDao {
	public void addCustomer(Customer customer);
	public ICustomer getCustomer(String email);
	public List<Customer> getCustomers();
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import model.Customer;
import utilities.ConnectionData;
import utilities.ConnectionUtility;

public class CustomerDao implements ICustomerDao{

	private ConnectionData conn_data = new ConnectionData();
	
	public CustomerDao() {}
	
	/*public CustomerDao (ConnectionData conn_data) {
		this.conn_data = conn_data;
	}*/
	
	@Override
	public void addCustomer(Customer customer) {
		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = ConnectionUtility.getConnection(conn_data);
			String sql = "Insert into customer values (?,?,?,?,?)";
			statement = con.prepareStatement(sql);
			statement.setString(1, customer.getFirstName());
			statement.setString(2, customer.getLastName());
			statement.setString(3, customer.getEmail());
			statement.setString(4, customer.getPassword());
			statement.setString(5, customer.getPhoneNumber());
			statement.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Customer> getCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

}

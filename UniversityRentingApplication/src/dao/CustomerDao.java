package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.*;
import utilities.ConnectionData;
import utilities.ConnectionUtility;

public class CustomerDao implements ICustomerDao {

	private ConnectionData conn_data = new ConnectionData();

	public CustomerDao(ConnectionData conn_data) {
		this.conn_data = conn_data;
	}

	public CustomerDao() {
	}

	/*
	 * public CustomerDao (ConnectionData conn_data) { this.conn_data = conn_data; }
	 */

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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ICustomer getCustomer(String email) {
		// TODO Auto-generated method stub
		Connection con = null;
		ICustomer customer = null;
		try {
			con = ConnectionUtility.getConnection(conn_data);
			
			Statement stmt = con.createStatement();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM customer where email = ?");
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
			customer = new Customer();
				
				customer.setFirstName(rs.getString("firstName"));
				customer.setLastName(rs.getString("lastName"));
				customer.setEmail(rs.getString("email"));
				customer.setPhoneNumber(rs.getString("phoneNumber"));
				customer.setPassword(rs.getString("password"));
			}
			stmt.close();
			// releaseConnection(con);

		} catch (SQLException e) {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e2) { /* ignore */
			}
		}
		return customer;
	}

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

}

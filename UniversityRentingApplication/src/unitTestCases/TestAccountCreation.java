package unitTestCases;
import api.LoginController;
import api.SignUpController;
import dao.CustomerDao;
import dao.DAO;
import model.Customer;
import service.CustomerService;
import utilities.ConnectionData;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import javax.servlet.http.HttpServletRequest;

public class TestAccountCreation {
	
	@Test
	public void returnExpectedCustomerObject() {
		
		int id = 4;
		String fname = "Rohan";
		String lname = "kapoor";
		String email = "r@uncc.edu";
		String password = "pass";
		String phone = "123456";
		
		Customer c = new Customer(id, fname, lname, email, password, phone);
		assertEquals(id, c.getID());
		assertEquals(fname, c.getFirstName());
		assertEquals(lname, c.getLastName());
		assertEquals(email, c.getEmail());
		assertEquals(password, c.getPassword());
		assertEquals(phone, c.getPhoneNumber());
	}
	
	@Test
	public void returnWebPageAction() {
		DAO d = new DAO();
		SignUpController lc = new SignUpController(d);
		String expectedPageToBeOn = "signUp.do";
		String result = lc.getName();
		assertEquals(expectedPageToBeOn, result);
	}
	
	
}

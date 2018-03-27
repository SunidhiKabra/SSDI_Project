package unitTestCases;
import api.LoginController;
import dao.CustomerDao;
import dao.DAO;
import model.Customer;
import utilities.ConnectionData;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import javax.servlet.http.HttpServletRequest;

public class TestLogIn {
	
	@Test
	public void returnExpectedPageWithNullValuesForLoginController() {
		
		HttpServletRequest hsr = null;
		DAO d = new DAO();
		LoginController lc = new LoginController(d);
		String result = lc.perform(hsr);
		String expectedPageToBeOn = "login.jsp";
		assertEquals(expectedPageToBeOn, result);
	}
	
	
	@Test
	public void checkIfDatabaseIsAddingDataAndGettingData() {
		Customer c = new Customer(1, "Rohan","Kapoor","rk@uncc.edu", "pass", "1234");
		
		
	}
}

package api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.*;
import model.*;

public class ViewRenterController extends Action {

	private CustomerDao customerDAO;

	public ViewRenterController(DAO dao) {
		this.customerDAO = dao.getCustomerDAO();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "viewRenter.do";
	}

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub

		List<String> errors = new ArrayList<String>();
		ICustomer renter = customerDAO.getCustomer("r@r.com");
		if (renter == null) {
			errors.add("No such customer");
		}

		request.setAttribute("errors", errors);
		request.setAttribute("renter", renter);

		return "viewRenter.jsp";

	}

}

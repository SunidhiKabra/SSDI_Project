package api;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;
import dao.*;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	boolean begin;

	public void init() throws ServletException {
		DAO dao = new DAO();
		Action.add(new ViewItemController(dao));
		Action.add(new HomePageController());
		Action.add(new ViewRenterController(dao));
		begin = false;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = performTheAction(request);
		sendToNextPage(nextPage, request, response);
	}

	/*
	 * Extracts the requested action and (depending on whether the user is logged
	 * in) perform it (or make the user login).
	 * 
	 * @param request
	 * 
	 * @return the next page (the view)
	 */
	private String performTheAction(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		String servletPath = request.getServletPath();
		// get it from session

		// UserBean user = (UserBean) session.getAttribute("user");
		// temp need to create session
		String user = null;
		String action = getActionName(servletPath);
		// add user favorites
		// if (begin == false) {
		// begin = true;
		// return Action.perform("setup.do", request);
		// }
	if (action.equals("login.do") || action.equals("viewOtherUsers.do")
				|| action.equals("viewOtherUsersFav.do") || action.equals("otherFavClickCount.do")
				|| action.equals("loggedOut.do")) {
			// Allow these actions without logging in
			return Action.perform(action, request);
		}
	/*			

		if (user == null) {
			// If the user hasn't logged in, so login is the only option
			return Action.perform("login.do", request);
		}
*/
		
		
		// Let the logged in user run his chosen action
		return Action.perform(action, request);
	}

	/*
	 * If nextPage is null, send back 404 If nextPage ends with ".do", redirect to
	 * this page. If nextPage ends with ".jsp", dispatch (forward) to the page (the
	 * view) This is the common case
	 */
	private void sendToNextPage(String nextPage, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		if (nextPage == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, request.getServletPath());
			return;
		}

		if (nextPage.endsWith(".do")) {
			response.sendRedirect(nextPage);
			return;
		}

		if (nextPage.endsWith(".jsp")) {
		//	RequestDispatcher d = request.getRequestDispatcher("WEB-INF/" + nextPage);
			RequestDispatcher d = request.getRequestDispatcher(nextPage);
			d.forward(request, response);
			return;
		}

		throw new ServletException(
				Controller.class.getName() + ".sendToNextPage(\"" + nextPage + "\"): invalid extension.");
	}

	/*
	 * Returns the path component after the last slash removing any "extension" if
	 * present.
	 */
	private String getActionName(String path) {
		// We're guaranteed that the path will start with a slash
		int slash = path.lastIndexOf('/');
		return path.substring(slash + 1);
	}
}
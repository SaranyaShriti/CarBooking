package carbooking.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import carbooking.model.Route;
import carbooking.service.UserService;

/**
 * Servlet calls the method in DAO to get all the routes from route table
 *
 */
public class RouteServlet extends HttpServlet {
	
	private static Log logger = LogFactory.getLog(RouteServlet.class);

	private static final long serialVersionUID = 7142549258399614575L;
	UserService userService;
	public void doPost(HttpServletRequest req,HttpServletResponse res)  
			throws ServletException,IOException  
	{  
		logger.info("Inside RouteServlet");
		userService = new UserService();
		List<Route> listOfRoutes = userService.listRoutes();
		req.setAttribute("listOfroutes", listOfRoutes);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("route.jsp");
		requestDispatcher.forward(req, res);


	}
}

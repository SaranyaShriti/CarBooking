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

import carbooking.model.Car;
import carbooking.service.UserService;

/**
 *To list the available cars from the DB
 * 
 */
public class CarServlet extends HttpServlet{
	
	private static Log logger = LogFactory.getLog(CarServlet.class);

	private static final long serialVersionUID = 7142549258399614575L;
	UserService userService;
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)  
			throws ServletException,IOException  
	{  
		logger.info("Successfully redirecting to page contains list of Cars");
		
	    HttpSession session = req.getSession(false);
		session.setAttribute("routeId", req.getParameter("id"));

		userService = new UserService();
		List<Car> listOfcars = userService.listCars();
		req.setAttribute("listOfcars", listOfcars);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("car.jsp");
		requestDispatcher.forward(req, res);


	}
	
}

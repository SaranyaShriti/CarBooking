package carbooking.controller;

import java.io.IOException;

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
 * To Book Car for particular user id with the selected route
 *
 */
public class BookServlet extends HttpServlet {
	
	private static Log logger = LogFactory.getLog(BookServlet.class);
	
	
	private static final long serialVersionUID = 1L;
	UserService userService;
	
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)  
			throws ServletException,IOException  
	{  
		
		logger.info("Inside BookServlet");
		
		userService = new UserService();
		int carId=Integer.valueOf(req.getParameter("carId"));
		
		HttpSession session = req.getSession(false);
		int userid = (int) session.getAttribute("userId"); 
		
		String routeId =  (String) session.getAttribute("routeId");
		userService.bookCar(carId,userid,Integer.valueOf(routeId));
		
		Car cardet=userService.carDetail(carId);
		req.setAttribute("car", cardet);
		
		logger.info("Successfully redirecting to confirmation page");
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("success.jsp");
		requestDispatcher.forward(req, res);

	}

}

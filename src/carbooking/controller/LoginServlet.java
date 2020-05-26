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
import carbooking.model.User;
import carbooking.service.UserService;
/**
 * Data given in the login form will be checked in DB to checked whether the user is valid
 *
 */
public class LoginServlet extends HttpServlet {
	
	private static Log logger = LogFactory.getLog(LoginServlet.class);

	
	private static final long serialVersionUID = 7142549258399614575L;
	UserService userService;
	public void doPost(HttpServletRequest req,HttpServletResponse res)  
			throws ServletException,IOException  
	{  
		
		logger.info("Inside LoginServlet");
		
		userService = new UserService();
		User user= new User();
		user.setUsername(req.getParameter("username"));
		user.setPassword(req.getParameter("password"));
		int userId=userService.checkUser(user);
		
	    HttpSession session = req.getSession();
		session.setAttribute("userId", userId);

		if(userId>0)
		{
			logger.info("Successfully redirecting to list of route page");

			userService = new UserService();
			List<Route> listOfRoutes = userService.listRoutes();
			req.setAttribute("listOfroutes", listOfRoutes);
			req.setAttribute("userId", userId);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("route.jsp");
			requestDispatcher.forward(req, res);
		}
		else
		{
			logger.info("Login Fails!");

			RequestDispatcher requestDispatcher = req.getRequestDispatcher("error.jsp");
			requestDispatcher.forward(req, res);
		}

	}

}

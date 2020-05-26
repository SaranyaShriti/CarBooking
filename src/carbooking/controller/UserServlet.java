package carbooking.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import carbooking.model.User;
import carbooking.service.UserService;


/**
 * Data given in the register form will be saved in DB
 *
 */
public class UserServlet extends HttpServlet{

	private static Log logger = LogFactory.getLog(UserServlet.class);

	private static final long serialVersionUID = 1L;
	UserService userService;
	public void doPost(HttpServletRequest req,HttpServletResponse res)  
			throws ServletException,IOException  
	{  
		
		logger.info("Inside UserServlet");
		
		
		userService = new UserService();
		User user= new User();
		user.setUsername(req.getParameter("username"));
		user.setPassword(req.getParameter("password"));
		user.setEmail(req.getParameter("email"));
		user.setMobile(req.getParameter("mobile"));

		if(userService.saveUser(user))
		{
			logger.info("Successfully redirecting to login page");

			RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(req, res);
		}
		else
		{
			logger.info("Registration fails!");

			RequestDispatcher requestDispatcher = req.getRequestDispatcher("error.jsp");
			requestDispatcher.forward(req, res);
		}

	}
}

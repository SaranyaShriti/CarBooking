package carbooking.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import carbooking.controller.CarServlet;
import carbooking.dao.UserDao;
import carbooking.model.Car;
import carbooking.model.Route;
import carbooking.model.User;

public class UserService {

	private static Log logger = LogFactory.getLog(UserService.class);

	
	UserDao userdao;
	
	public boolean saveUser(User user)
	{
		logger.info("User service ");

		userdao = new UserDao();
		return userdao.saveUser(user);
	}
	
	public int checkUser(User user)
	{
		logger.info("User service ");

		userdao = new UserDao();
		return userdao.checkUser(user);

	}

	public List<Route> listRoutes() {
		logger.info("User service ");
 
		userdao = new UserDao();
		return userdao.listRoutes();
	}
	
	public List<Car> listCars() {
		
		logger.info("User service ");

		userdao = new UserDao();
		return userdao.listCars();
	}
	
	public void bookCar(int carId,int userId, int routeId)
	{
		logger.info("User service ");

		userdao = new UserDao();
	    userdao.bookCar(carId,userId,routeId);
	    
	}
	
	public Car carDetail(int carId)
	{
		logger.info("User service ");

		userdao = new UserDao();
	    return userdao.detailCar(carId);
	    
	}
}

package carbooking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import carbooking.model.User;
import carbooking.controller.CarServlet;
import carbooking.model.Car;
import carbooking.model.Route;

public class UserDao {

	private static Log logger = LogFactory.getLog(UserDao.class);

	public boolean saveUser(User user)
	{
		try { 

			Connection con = DatabaseConnection.initializeDatabase();

			logger.info("Registering new User");
			
			PreparedStatement st = con.prepareStatement("insert into carbooking.user(username,password,mobile,email) values(?,?,?,?)");
			st.setString(1, user.getUsername());
			st.setString(2, user.getPassword()); 
			st.setString(3, user.getMobile()); 
			st.setString(4, user.getEmail());

			int insertId = st.executeUpdate();

			if(insertId==1)
				return true;
			st.close();
			con.close(); 
		} 
		catch (Exception e) { 
			
			logger.info("Cant register new User");

			e.printStackTrace(); 
		} 
		return false;

	}

	public int checkUser(User user) {
		try { 
			
			logger.info("Checking User credentials");


			Connection con = DatabaseConnection.initializeDatabase();
			Statement statement = con.createStatement();

			String sql = "select * from user where username='"+user.getUsername()+"' AND password='"+user.getPassword()+"'";

			ResultSet result = statement.executeQuery(sql);

			if(result.next()) {
				return result.getInt("id");
			}
			
			statement.close();
			con.close(); 
		} 
		catch (Exception e) { 
			logger.info(" User credentials not found");

			e.printStackTrace(); 
		} 
		return 0;

	}

	public List<Route> listRoutes() {
		List<Route> listOfRoute = new ArrayList<Route>();
		try { 
			
			logger.info("Selecting all routes");


			Connection con = DatabaseConnection.initializeDatabase();
			Statement statement = con.createStatement();

			String sql = "select * from route";
			ResultSet result = statement.executeQuery(sql);
			while(result.next()) {
				Route route = new Route();
				route.setRouteId(result.getInt("routeId"));
				route.setSource(result.getString("source"));
				route.setDestination(result.getString("destination"));
				route.setFare(result.getDouble("fare"));
				listOfRoute.add(route);
			}
			
			statement.close();
			con.close(); 
			return listOfRoute;
		} 
		catch (Exception e) { 
			
			logger.info("Routes not found");

			e.printStackTrace(); 
		} 
		return listOfRoute;

	}
	
	
	public List<Car> listCars()
	{
		List<Car> listCar = new ArrayList<Car>();
		try { 

			logger.info("Selecting all available cars");

			Connection con = DatabaseConnection.initializeDatabase();
			Statement statement = con.createStatement();

			String sql = "select * from carbooking.car where isAvailable=1";
			ResultSet result = statement.executeQuery(sql);
			while(result.next()) {
				Car car = new Car();
				car.setCarId(result.getInt("carId"));
				car.setCarNumber(result.getString("carNumber"));
				car.setCarType(result.getString("carType"));
				car.setSeater(result.getInt("seater"));
				listCar.add(car);
			}
			
			statement.close();
			con.close(); 
			return listCar;
		} 
		catch (Exception e) { 
			
			logger.info("Cars Not Found!");

			e.printStackTrace(); 
		} 
		return listCar;

	}
	
	public void bookCar(int carId, int userId, int routeId)
	{
		try { 
			logger.info("Book car from user data");


			Connection con = DatabaseConnection.initializeDatabase();
			
			PreparedStatement stcar = con.prepareStatement("update carbooking.car set isAvailable=0 where carId=?");
			stcar.setInt(1, carId); 
			PreparedStatement st = con.prepareStatement("insert into carbooking.ride(userId,routeId,carId,bookingTime) values(?,?,?,CURRENT_TIMESTAMP)");
			st.setInt(1, userId);
			st.setInt(2, routeId); 
			st.setInt(3, carId); 
			stcar.executeUpdate();
			st.executeUpdate();
			st.close();
			con.close(); 
		} 
		catch (Exception e) { 
			
			logger.info("Cannot book car!");

			e.printStackTrace(); 
		} 
	}
	public Car detailCar(int carId)
	{
		Car car = new Car();

		try { 

			logger.info("Get Car details from car id");

			Connection con = DatabaseConnection.initializeDatabase();
			Statement statement = con.createStatement();

			String sql = "select * from carbooking.car where carId='"+carId+"'";
			ResultSet result = statement.executeQuery(sql);
			if(result.next()) {
				car.setCarNumber(result.getString("carNumber"));
				car.setCarType(result.getString("carType"));
				car.setSeater(result.getInt("seater"));
			}
			
			statement.close();
			con.close(); 
			return car;
		} 
		catch (Exception e) { 
			
			logger.info("Cant get car details!");

			e.printStackTrace(); 
		} 
		return car;

	}
	


}

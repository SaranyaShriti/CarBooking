package carbooking.model;

import java.sql.Timestamp;
public class Ride {
	
	private int rideId;
	private int userId;
	private int routeId;
	private int carId;
	private Timestamp bookingTime;
	public int getRideId() {
		return rideId;
	}
	public void setRideId(int rideId) {
		this.rideId = rideId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public Timestamp getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(Timestamp bookingTime) {
		this.bookingTime = bookingTime;
	}
	
	

}

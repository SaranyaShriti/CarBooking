package carbooking.model;

public class Car {

	private int carId;
	private String carNumber;
	private String carType;
	private int seater;
	private boolean isAvailable;
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public int getSeater() {
		return seater;
	}
	public void setSeater(int seater) {
		this.seater = seater;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	
}

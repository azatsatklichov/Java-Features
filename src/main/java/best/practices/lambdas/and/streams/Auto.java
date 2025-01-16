package best.practices.lambdas.and.streams;

public class Auto implements Comparable<Auto> {
	public String brand;
	public String numberPlate;
	public int noOfDoors;

	public Auto(String brand, String numberPlate, int noOfDoors) {
		this.brand = brand;
		this.numberPlate = numberPlate;
		this.noOfDoors = noOfDoors;
	}

	@Override
	public String toString() {
		return "Auto [brand=" + brand + ", numberPlate=" + numberPlate + ", noOfDoors=" + noOfDoors + "]";
	}

	public String getBrand() {
		return brand;
	}

	public String getNumberPlate() {
		return numberPlate;
	}

	public int getNoOfDoors() {
		return noOfDoors;
	}

	@Override
	public int compareTo(Auto o) {
		return numberPlate.compareTo(o.numberPlate);
	}

}

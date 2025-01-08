package best.practices.records;

import java.time.LocalDate;
import java.util.Objects;


public final class VeboseCar {
	private final String model;
	private final LocalDate producedDate;
	private final String vin;

	public VeboseCar(String model, LocalDate producedDate, String vin) {
		this.model = model;
		this.producedDate = producedDate;
		this.vin = vin;
	}

	public String model() {
		return model;
	}

	public LocalDate producedDate() {
		return producedDate;
	}

	public String vin() {
		return vin;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		VeboseCar otherCar = (VeboseCar) o;
		return Objects.equals(model, otherCar.model) && Objects.equals(producedDate, otherCar.producedDate)
				&& Objects.equals(vin, otherCar.vin);
	}

	@Override
	public int hashCode() {
		return Objects.hash(model, producedDate, vin);
	}

	@Override
	public String toString() {
		return "Car [" + "model=" + model + ", producedDate=" + producedDate + ", vin=" + vin + ']';
	}
}
package best.practices.records;

import java.util.Objects;

//Vanilla Code
public final class Adam {

	private final String name;
	private final String address;

	public Adam(String name, String address) {
		this.name = name;
		this.address = address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, address);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (!(obj instanceof Adam)) {
			return false;
		} else {
			Adam other = (Adam) obj;
			return Objects.equals(name, other.name) && Objects.equals(address, other.address);
		}
	}

	@Override
	public String toString() {
		return "Adam [name=" + name + ", address=" + address + "]";
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}
}

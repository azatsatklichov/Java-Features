package best.practices.lambdas.and.streams.notyet.action;

public class Apple {
	private int weight = 0;
	private String color = "";
	private int price = 0;

	public Apple(int weight, String color, Integer price) {
		this.weight = weight;
		this.color = color;
		this.price = price;
	}
	
	public Apple(int weight, String color) {
		this(weight, color, 0);
	}

	public Apple(String color) {
		this(23, color);
	}

	public Apple() {
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	

	public int getPrice() {
		return price;
	}

	public String toString() {
		return "Apple{" + "color='" + color + '\'' + ", weight=" + weight + ", Price="+price+ '}';
	}
}

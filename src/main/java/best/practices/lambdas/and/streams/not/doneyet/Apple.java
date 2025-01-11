package best.practices.lambdas.and.streams.not.doneyet;

public class Apple {

    private int weight = 0;
    private Color color;
    private int price = 0;

    public Apple(int weight, Color color) {
        this.weight = weight;
        this.color = color;
    }

    public Apple(int weight, Color color, Integer price) {
        this.weight = weight;
        this.color = color;
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    @SuppressWarnings("boxing")
    @Override
    public String toString() {
        return String.format("Apple{color=%s, weight=%d, weight=%d}", color, weight, price);
    }

}


enum Color {
    RED, GREEN
}
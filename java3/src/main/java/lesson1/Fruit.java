package lesson1;

import java.util.Objects;

public class Fruit {
    private double weight;
    private String color;
    private double price;
    public String name = "фрукт";


    public Fruit(double weight) {
        this.weight = weight;
    }

    public Fruit(double weight, String color, double price) {
        this.weight = weight;
        this.color = color;
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return Double.compare(fruit.weight, weight) == 0 &&
                color == fruit.color &&
                Double.compare(fruit.price, price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, color, price);
    }
}

package lesson1;

import java.util.Objects;

public class Orange extends Fruit {
    public final String name = "Апельсин";

    public Orange(double weight) {
        super(weight);
    }

    public Orange(double weight, String color, double price) {
        super(weight, color, price);
    }

    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apple apple = (Apple) o;
        return Objects.equals(name, apple.name) &&  super.equals(o);
    }

    @Override
    public int hashCode() {
        return 31* Objects.hash(name)+ super.hashCode();
    }

    @Override
    public String toString() {
        return  name + " вес " + getWeight()+
                ", цвет " + getColor() +
                ", цена " + getPrice();
    }
}

package lesson1;
import java.util.Objects;

public class Apple extends Fruit {
    public final String name = "Яблоко";
    private String sort;

    public Apple(double weight, String sort) {
        super(weight);
        this.sort = sort;
    }

    public Apple(double weight, String color, double price, String sort) {
        super(weight, color, price);
        this.sort = sort;
    }

    public String getName() {
        return name;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apple apple = (Apple) o;
        return Objects.equals(name, apple.name) &&
                Objects.equals(sort, apple.sort) && super.equals(o);
    }

    @Override
    public int hashCode() {
        return 31*Objects.hash(name, sort)+ super.hashCode();
    }

    @Override
    public String toString() {
        return  name + ": сорт " +  sort +
                ", вес " + getWeight()+
                ", цвет " + getColor() +
                ", цена " + getPrice();
    }
}

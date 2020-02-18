package lesson3;

import java.io.Serializable;

public class Employee  implements Serializable {
    private int id;
    private String FIO;
    private String post;
    private double age;

    public Employee(int id, String FIO, String post, double age) {
        this.id = id;
        this.FIO = FIO;
        this.post = post;
        this.age = age;
    }

    public String info() {
        return "Штат сотрудников{" +
                "id=" + id +
                ", ФИО='" + FIO + '\'' +
                ", должность='" + post + '\'' +
                ", возвраст=" + age +
                '}';
    }
}

package lesson1;

import java.util.Scanner;

public class Main {
    interface ArithmeticCalc{
        double makeOperation(double a,double b);
    }

    public static void main(String[] args) {
        Integer[] intarr = {1,2,3,4,5,6,7};
        UniArray<Integer> myintarr = new UniArray<>(intarr);
        myintarr.swapped(1,3);
        System.out.println(myintarr.toString());

        System.out.println(myintarr.toArrayList().toString());

        String[] strarr = {"ivanov", "petrov","sidirov", "pupkin"};
        UniArray<String> mystrarr = new UniArray<>(strarr);
        mystrarr.swapped(1,3);
        System.out.println(mystrarr.toString());


        Box<Apple> appleBox = new Box<>(3);
        Box<Orange> orangeBox = new Box<>(3);

        appleBox.add(new Apple(1.1, "красное", 180, "макинтош"));
        appleBox.add(new Apple(1.2,"желтое" ,150,"антоновка"));

        orangeBox.add(new Orange(1.4));
        orangeBox.add(new Orange(1.5));

        System.out.println("Коробка яблок весит "+ appleBox.getWeight());
        System.out.println("Апельсин яблок весит "+ orangeBox.getWeight());
        System.out.println((appleBox.compare(orangeBox))? "Веса коробок равны": "Веса коробок неравны");

        appleBox.add(new Apple(0.6, "райские"));
        System.out.println((appleBox.compare(orangeBox))? "Веса коробок равны": "Веса коробок неравны");

        Box<Apple> appleBoxLarge = new Box<>(10);
        appleBox.moveTo(appleBoxLarge);
        System.out.println(appleBoxLarge.toString());
        appleBoxLarge.moveTo(appleBox);
        System.out.println(appleBox.toString());



        Scanner in = new Scanner(System.in);
        System.out.println("Введите арифметическую операцию  и два числа, с которыми ее нужно провести");

        String operation = in.nextLine();
        double x = in.nextDouble();
        double y = in.nextDouble();

        switch (operation) {
            case "+":   ArithmeticCalc addition = ((a, b) -> a + b);
                System.out.println(addition.makeOperation(x, y));
                break;

            case "-":   ArithmeticCalc substraction = ((a, b) -> a - b);
                System.out.println(substraction.makeOperation(x, y));
                break;

            case "*":   ArithmeticCalc multiplication = ((a, b) -> a * b);
                System.out.println(multiplication.makeOperation(x, y));
                break;

            case "/":   ArithmeticCalc division = ((a, b) -> a / b);
                System.out.println(division.makeOperation(x, y));
                break;
        }

    }

}

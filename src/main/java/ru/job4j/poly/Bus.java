package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Поехали!");
    }

    @Override
    public void passengers(int passeng) {
        System.out.println("В автобус купили билеты " + passeng + " пассажиров");

    }

    @Override
    public int fuel(int litr, int price) {
        int bak = litr * price;
        System.out.println("Заправить полный бак будет стоить " + bak + " рублей.");
        return bak;
    }
}

package ru.job4j.oop;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " ездит по шоссе");
    }

    @Override
    public void driver() {
        System.out.println(getClass().getSimpleName() + " управляет водитель");
    }
}

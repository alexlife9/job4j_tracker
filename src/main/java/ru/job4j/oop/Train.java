package ru.job4j.oop;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " ездит по железной дороге");
    }

    @Override
    public void driver() {
        System.out.println(getClass().getSimpleName() + " управляет машинист");
    }
}

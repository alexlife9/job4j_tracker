package ru.job4j.io;

import java.util.Scanner;
import java.util.Random;

public class MagicBall {
    @SuppressWarnings("checkstyle:RightCurly")
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int answer = new Random().nextInt(3);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        String name = input.nextLine();
        if (answer == 1) {
            System.out.println(name + " - ДА");
        } else if (answer == 2) {
            System.out.println(name + " - НЕТ");
        } else {
            System.out.println(name + " - МОЖЕТ БЫТЬ");
        }
    }
}
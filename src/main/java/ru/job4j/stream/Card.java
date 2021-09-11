package ru.job4j.stream;

import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private ValueNum valueNum;

    public Card(Suit suit, ValueNum valueNum) {
        this.suit = suit;
        this.valueNum = valueNum;
    }

    public enum Suit {
        Diamonds, Hearts, Spades, Clubs
    }

    public enum ValueNum {
        V_6, V_7, V_8
    }

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(ValueNum.values())
                        .map(valueNum -> new Card(suit, valueNum)))
                .forEach(System.out::println);
    }
}
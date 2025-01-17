package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };
        /**
         *         Comparator<Attachment> comparator = new Comparator<Attachment>() {
         *             @Override
         *             public int compare(Attachment left, Attachment right) {
         *                 return left.getSize() - right.getSize();
         *             }
         *         };
         */
        Comparator<Attachment> comparator = Comparator.comparingInt(Attachment::getSize);
        Comparator<String> cmpSize = Comparator.comparingInt(String::length);
        Comparator<String> cmpText = String::compareTo;
        Comparator<String> cmpDescSize = (left, right) -> right.length() - left.length();

        Arrays.sort(atts, comparator);
    }
}
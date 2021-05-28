package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book headFirst = new Book("Head First", 708);
        Book java = new Book("Java Шилдт", 1500);
        Book grokaem = new Book("Грокаем алгоритмы", 290);
        Book cleanCode = new Book("Clean Code", 0);

        Book[] books = new Book[4];
        books[0] = headFirst;
        books[1] = java;
        books[2] = grokaem;
        books[3] = cleanCode;
        for (Book bk : books) {
            System.out.println(bk.getName() + " - " + bk.getQuantity() + " стр.");
        }

        System.out.println();
        System.out.println("Меняем местами первую книгу с четвертой");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (Book bk : books) {
            System.out.println(bk.getName() + " - " + bk.getQuantity() + " стр.");
        }

        System.out.println();
        System.out.println("Выводим книгу именем \"Clean code\"");
        for (Book bk : books) {
            if (bk.getName().equals("Clean code")) {
                System.out.println(bk.getName() + " - " + bk.getQuantity() + " стр.");
            }
        }
    }
}

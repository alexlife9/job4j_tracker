package ru.job4j.oop;
/*
Пример использования Java foreach
Создадим массив из оценок ученика.
Затем с помощью for-each распечатаем все оценки,
выведем среднюю оценку и найдём максимальную из них.
*/

public class ForEachGrades {

    /**
     * метод, который распечатывает все оценки
     */
    public static void printAllGrades(int[] grades) {
        System.out.print("|");
        for (int num : grades) {

            System.out.print(num + "|");
        }
        System.out.println();
    }

    /**
     * метод, в котором выводится средняя оценка
     * @param numbers
     * @return
     */
    public static double midGrade(int[] numbers) {
        int grade = 0;

        for (int num : numbers) {
            grade = num + grade;
        }
        return ((double) grade / numbers.length);

    }

    /**
     * метод в котором вычисляется лучшая (максимальная) оценка
     * @param numbers
     * @return
     */
    public static int bestGrade(int[] numbers) {
        int maxGrade = numbers[0];

        for (int num : numbers) {
            if (num > maxGrade) {
                maxGrade = num;
            }
        }
        return maxGrade;
    }

    public static void main(String[] args) {
        int[] grades = {5, 10, 7, 8, 9, 9, 10, 12};
        int highestMarks = bestGrade(grades);
        System.out.print("All the grades: ");
        printAllGrades(grades);
        System.out.println("The highest grade is " + highestMarks);
        System.out.println("The average grade is " + midGrade(grades));
    }
}

package ru.job4j.collection;

import java.util.List;

public class ConvertList2Array {
    public static int[][] toArray(List<Integer> list, int cells) {
        int groups = (int) Math.ceil((double) list.size() / cells);
        int[][] array = new int[groups][cells];
        int row = 0, cell = 0;
        for (Integer num : list) {
            array[row][cell++] = num;
            if (cell == cells) {
                row++;
                cell = 0;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);
        int[][] rsl = toArray(list, 3);
        for (int[] row : rsl) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}

//проходим для каждого num из листа
//записываем переменную в num
//записываем эту переменную в массив в нулевую ячейку роу (это будет первый ряд)
//и в селл закидываем значения из листа
//[cell++] это означает что мы сразу к 0 прибавили 1 и поехали дальше до ифа.
//в ифе мы проверяем что селл = селлс (а селлс у нас установлено 3),
//если это не так, то едем дальше. пропуская row++ и cell = 0;
//поэтому возвращаемся в фор и прибавляем в ряд к селл еще одно значение листа
//потом когда селл = селлс, начинаем пихать числа во второй ряд
//и так до третьего ряда пока числа из листа не кончатся
//после заполнения первого ряда сначала прибавляем ряд, а потом обнуляем селл и идем обратно в фор
//все оставшиеся ячейки нулями забиваются по умолчанию, если числа из листа закончились

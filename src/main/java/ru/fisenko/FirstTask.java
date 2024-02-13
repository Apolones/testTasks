package ru.fisenko;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FirstTask {

    public static void main(String[] args) { //Надо сделать считывание данных из какого-то источника (в условии нет, поэтому оставил неправильно в коде)
        int size = 10;
        int min = -10;
        int max = 10;
        List<Integer> arrayList = generateRandomArrayList(size, min, max);
        System.out.println("List:\n" + arrayList);
        sortArrayList(arrayList);
        System.out.println("\nSorted List:\n" + arrayList);
    }

    public static List<Integer> generateRandomArrayList(int size, int min, int max) { // Метод для генерации случайного массива
        if (size <= 0) {
            throw new IllegalArgumentException("Size should be greater than zero.");
        }
        List<Integer> arrayList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arrayList.add(random.nextInt(max - min + 1) + min);
        }
        return arrayList;
    }

    public static void sortArrayList(List<Integer> arrayList) { //Сортировка используя компаратор сначала по возрастанию нечетные числа,потом нули, потом четные по убыванию
        arrayList.sort((a, b) -> {
            if (a % 2 != 0 && b % 2 != 0) {
                return a - b;
            } else if (a % 2 != 0) {
                return -1;
            } else if (b % 2 != 0) {
                return 1;
            } else if (a == 0) {
                return -1;
            } else if (b == 0) {
                return 1;
            } else {
                return b - a;
            }
        });
    }
}

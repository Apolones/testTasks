package ru.fisenko;

import java.util.*;

public class SecondTask {
    public static void main(String[] args) {
        List<Integer> arrayList = generateRandomArrayList(10);
        System.out.println("List:\n" + arrayList);
        System.out.println("\nMost common number:\n" + findMostFrequentNumbers(arrayList));
    }

    public static List<Integer> generateRandomArrayList(int size) { // Метод для генерации случайного массива
        List<Integer> arrayList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arrayList.add(random.nextInt(21) - 10);
        }
        return arrayList;
    }

    public static List<Integer> findMostFrequentNumbers(List<Integer> array) {
        Map<Integer, Integer> frequencyMap = new HashMap<>(); //Массив для хранения уникальных значений и количество их в исходном массиве
        for (int number : array
        ) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }

        int maxFrequency = Collections.max(frequencyMap.values());
        List<Integer> mostFrequentNumbers = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entery : frequencyMap.entrySet()
        ) {
            if (entery.getValue() == maxFrequency) mostFrequentNumbers.add(entery.getKey());
        }
        return mostFrequentNumbers;
    }
}

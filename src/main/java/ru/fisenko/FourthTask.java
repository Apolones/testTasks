package ru.fisenko;

import java.util.Arrays;

public class FourthTask {
    public static void main(String[] args) { //Надо сделать считывание данных из какого-то источника (в условии нет, поэтому оставил неправильно в коде)
        int[] nums = {10, 5, 7, 5, 13, 6};
        int k = 4;
        int[] order = partitionKSubsets(nums, k);
        printSets(nums, k , order);
    }

    public static int[] partitionKSubsets(int[] nums, int k) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int[] visited = new int[nums.length]; // Массив для отслеживания посещенных элементов с указанием шага, на котором был посещен

        if ((2 * totalSum - k * (k - 1)) % (2 * k) != 0) { // Если массив не делится на k подмножеств с увеличивающеся суммой, разбиение невозможно
            return visited;
        }

        int targetSum = (2 * totalSum - k * (k - 1)) / (2 * k); // Целевая сумма первого подмножества

        backtrack(nums, k, 0, 0, targetSum, visited);
        return visited;
    }

    private static void printSets(int[] nums, int k, int[] order) { //Вывод подмножеств в формате "все элементы подмножества : сумма элементов"
        System.out.println(Arrays.toString(nums) + " K=" + k);
        if(order[0]==0) {
            System.out.println("impossible");
            return;
        }
        for (int j = k; j > 0; j--) {
            int sum = 0;
            for (int i = 0; i < order.length; i++) {
                if (order[i] == j) {
                    System.out.print(nums[i] + " ");
                    sum += nums[i];
                }
            }
            System.out.println(":" + sum);
        }
    }

    public static boolean backtrack(int[] nums, int k, int start, int currentSum, int targetSum, int[] visited) {
        if (k == 0) {
            return true; // Все k подмножества сформированы
        }

        if (currentSum == targetSum) {
            return backtrack(nums, k - 1, 0, 0, targetSum + 1, visited); // Начать формирование следующего подмножества
        }

        for (int i = start; i < nums.length; i++) {
            if (visited[i] == 0 && currentSum + nums[i] <= targetSum) {
                visited[i] = k;
                if (backtrack(nums, k, i + 1, currentSum + nums[i], targetSum, visited)) {
                    return true; // Рекурсивно ищем следующие элементы
                }
                visited[i] = 0; // Откатываем изменения
            }
        }

        return false; // Не удалось найти подходящее подмножество
    }
}
package ru.fisenko;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThirdTask {

    static int countRolls = 100;
    static int countGame = 100000;

    public static void main(String[] args) {
        List<Integer> firstPlayerNumbers = rollDice(3);
        List<Integer> secondPlayerNumbers = rollDice(3);

        combinationWinrate(firstPlayerNumbers, secondPlayerNumbers);
    }

    public static List<Integer> rollDice(int count) { //Метод для генерации нескольких случайних бросков кубика
        List<Integer> arrayList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            arrayList.add(random.nextInt(6) + 1);
        }
        return arrayList;
    }

    public static int playerScore(List<Integer> diceRolls, List<Integer> playerNumbers) { //Вычесление счета
        int left = 0;
        int right = 0;
        int size = playerNumbers.size();
        int score = 0;
        while (left < diceRolls.size() - size) {
            if (right == 3) {
                score++;
                right = 0;
                left += 3;
            } else if (diceRolls.get(left + right) == playerNumbers.get(right)) right++;
            else {
                left++;
                right = 0;
            }
        }
        return score;
    }

    public static int firstPlayerWin(List<Integer> firstPlayerNumbers, List<Integer> secondPlayerNumbers) {
        List<Integer> diceRoll = rollDice(countRolls);
        int whoWin = playerScore(diceRoll, firstPlayerNumbers) - playerScore(diceRoll, secondPlayerNumbers);
        return Integer.compare(whoWin, 0);
    }

    public static void combinationWinrate(List<Integer> firstPlayerNumbers, List<Integer> secondPlayerNumbers) {
        int win = 0;
        int equal = 0;
        int lose = 0;
        for (int i = 0; i < countGame; i++) {
            int result = firstPlayerWin(firstPlayerNumbers, secondPlayerNumbers);
            if (result > 0) win++;
            else if (result < 0) lose++;
            else equal++;
        }
        printWinrate(firstPlayerNumbers, secondPlayerNumbers, win, equal, lose);
    }

    public static void printWinrate(List<Integer> firstPlayerNumbers, List<Integer> secondPlayerNumbers, int win, int equal, int lose){
        System.out.println("Winrate " + firstPlayerNumbers + " " + (float) win / countGame);
        System.out.println("Winrate " + secondPlayerNumbers + " " + (float) lose / countGame);
        System.out.println("Equal " + (float) equal / countGame);
    }
}

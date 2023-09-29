package org.alinatynystanova;

import java.lang.reflect.Array;
import java.util.*;


public class RockPaperScissors {

    /**
     * Method returns the choice of an active player.
     *
     * @param scanner
     * @return
     */
    public static int activeChoice(Scanner scanner) {
        int choice;
        while (true) {
            choice = scanner.nextInt();
            if (choice >= 1 && choice <= 3) {
                break;
            } else {
                System.out.println("Число не соответствует требованиям. Введите еще раз.");
            }
        }
        return choice;
    }

    /**
     * Method returns the names of choices.
     *
     * @param choice
     * @return
     */
    public static String game(int choice) {
        if (choice == 1) {
            return "Камень";
        } else if (choice == 2) {
            return "Ножницы";
        } else {
            return "Бумага";
        }
    }

    /**
     * Returns random choices that computer chooses.
     *
     * @return
     */
    public static int randomChoice() {
        Random random = new Random();
        return random.nextInt(3) + 1;
    }

    /**
     * This is the method that return results of the round.
     *
     * @param playerChoice
     * @param computerChoice
     * @return
     */
    public static String roundResults(int playerChoice, int computerChoice) {
        if (playerChoice == computerChoice) {
            return "Ничья";
        } else if ((playerChoice == 1 && computerChoice == 2) || (playerChoice == 2 && computerChoice == 3) || (playerChoice == 3 && computerChoice == 1)) {
            return "Вы выиграли";
        } else {
            return "Вы проиграли";
        }
    }

    /**
     * Method returns percentage of the rounds.
     *
     * @param count
     * @param total
     * @return
     */
    public static double percentage(int count, int total) {
        return (double) count / total * 10;
    }


    public static void main(String[] args) {
        System.out.println("Сколько игр Вы желаете сыграть?");
        int playerWins = 0;
        int computerWins = 0;
        int ties = 0;

        Scanner scanner = new Scanner(System.in);
        int games = scanner.nextInt();
        for (int i = 0; i < games; i++) {
            if (games < 5) {
                games = 5;
            } else if (games >= 20) {
                games = 20;
            }

            System.out.println("Выберите действие:");
            System.out.println("1) Камень");
            System.out.println("2) Ножницы");
            System.out.println("3) Бумага");

            int playerChoice = activeChoice(scanner);
            String gamePlayer = game(playerChoice);
            System.out.println(gamePlayer);

            int computerChoice = randomChoice();
            String computer = game(computerChoice);
            System.out.println("Противник выбрал: " + computer);

            String result = roundResults(playerChoice, computerChoice);
            System.out.println(result);
            if (result.equals("Вы выиграли")) {
                playerWins++;
            } else if (result.equals("Вы проиграли")) {
                computerWins++;
            } else {
                ties++;
            }
            System.out.println();
        }

        System.out.println("Статистика: ");
        System.out.println("Выигрыши: " + playerWins + percentage(playerWins, games) + " %");
        System.out.println("Проигрыши: " + computerWins + percentage(computerWins, games) + " %");
        System.out.println("Ничьи: " + ties + percentage(ties, games) + " %");
    }
}





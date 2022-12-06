package day_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RockPaperScissorsGuide_2 {
    public static void main(String[] args) {
        // Rock 'A' 'X'
        // Paper 'B' 'Y'
        // Scissors 'C' 'Z'

        Map<Character, Integer> winningCombination = new HashMap<>();
        winningCombination.put('A', 2); // opponent Rock points for me
        winningCombination.put('B', 3); // Paper
        winningCombination.put('C', 1); // Scissors

        Map<Character, Integer> drawCombination = new HashMap<>();
        drawCombination.put('A', 1);
        drawCombination.put('B', 2);
        drawCombination.put('C', 3);

        Map<Character, Integer> losingCombination = new HashMap<>();
        losingCombination.put('A', 3);
        losingCombination.put('B', 1);
        losingCombination.put('C', 2);

        Map<Character, String> playOutcome = new HashMap<>();
        playOutcome.put('X', "lose");
        playOutcome.put('Y', "draw");
        playOutcome.put('Z', "win");

        int win = 6;
        int draw = 3;

        try {
            File input = new File("src/day_2/input.txt");
            Scanner scanner = new Scanner(input);

            String inputLine;
            int score = 0;
            while (scanner.hasNext()){
                inputLine = scanner.nextLine();
                char opponentMove = inputLine.charAt(0);
                char outcome = inputLine.charAt(2);
                if (playOutcome.get(outcome)=="win") {
                    score += win + winningCombination.get(opponentMove);
                } else if (playOutcome.get(outcome)=="draw") {
                    score += draw + drawCombination.get(opponentMove);
                } else {
                    score += losingCombination.get(opponentMove);
                }
            }
            scanner.close();
            System.out.println(score);
        } catch (FileNotFoundException e) {
            System.out.println("An error has occurred");
            e.printStackTrace();
        }
    }
}

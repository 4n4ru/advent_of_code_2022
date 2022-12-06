package day_2;

import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RockPaperScissorsGuide {
    public static void main(String[] args) {
        // Rock 'A' 'X'
        // Paper 'B' 'Y'
        // Scissors 'C' 'Z'

        Map<Character, Integer> myScore = new HashMap<>();
        myScore.put('X', 1); // Rock
        myScore.put('Y', 2); // Paper
        myScore.put('Z', 3); // Scissors

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
                char myMove = inputLine.charAt(2);
                if ((myMove == 'X' && opponentMove == 'A') || (myMove == 'Y' && opponentMove == 'B') || (myMove == 'Z' && opponentMove == 'C')){
                    score += myScore.get(myMove) + draw;
                } else if((myMove == 'X' && opponentMove == 'C') || (myMove == 'Y' && opponentMove == 'A') || (myMove == 'Z' && opponentMove == 'B')){
                    score += myScore.get(myMove) + win;
                } else {
                    score += myScore.get(myMove);
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

package day_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MostCaloriesPerElf {
    public static void main(String[] args) {
        int mostCalories = 0;
        int currentElfCalories = 0;
        List<Integer> caloriesPerElf = new ArrayList<>();
        try {
            File file = new File("/Users/ana.runje/IdeaProjects/advent_of_code/src/day_1/input.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()){
                String next = scanner.nextLine();
                if ( next.equals("")) {
                    caloriesPerElf.add(currentElfCalories);
                    currentElfCalories = 0;
                } else {
                    currentElfCalories += Integer.parseInt(next);
                }
            }
            scanner.close();
            Collections.sort(caloriesPerElf, Collections.reverseOrder());
            int topThreeElvesCalories = 0;
            for (int i = 0; i<3 ; i++) {
                topThreeElvesCalories += caloriesPerElf.get(i);
            }
            System.out.println(topThreeElvesCalories);

        } catch (FileNotFoundException e){
            System.out.println("An error has occurred");
            e.printStackTrace();
        }

    }
}

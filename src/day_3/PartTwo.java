package day_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class PartTwo {
    public static void main(String[] args) throws FileNotFoundException {
        Map<Character, Integer> priority = RucksackReorganization.getCharacterIntegerMap();
        File input = new File("src/day_3/input.txt");
        Scanner scanner = new Scanner(input);
        String line1;
        String line2;
        String line3;
        int prioritySum = 0;
        while (scanner.hasNextLine()){
            line1 = scanner.nextLine();
            line2 = scanner.nextLine();
            line3 = scanner.nextLine();
            for (int i = 0; i < line1.length(); i++){
                if(line2.indexOf(line1.charAt(i))!=-1 && line3.indexOf(line1.charAt(i))!=-1){
                    prioritySum += priority.get(line1.charAt(i));
                    break;
                }
            }
        }
        System.out.println(prioritySum);
    }
}

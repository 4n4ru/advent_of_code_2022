package day_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RucksackReorganization {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("src/day_3/input.txt");
        Scanner scanner = new Scanner(input);
        int prioritySum = 0;
        Map<Character, Integer> priority = getCharacterIntegerMap();
        String line;
        while (scanner.hasNextLine()){
            line = scanner.nextLine();
            String firstCompartment = line.substring(0, line.length()/2);
            String secondCompartment = line.substring((line.length()/2));
            for (int i = 0; i < firstCompartment.length(); i++) {
                if(secondCompartment.indexOf(firstCompartment.charAt(i))!=-1){
                    prioritySum += priority.get(firstCompartment.charAt(i));
                    break;
                }
            }
        }
        System.out.println(prioritySum);
    }

    public static Map<Character, Integer> getCharacterIntegerMap() {
        Map<Character, Integer> priority = new HashMap<>();
        int value = 1;
        for(char letter = 'a'; letter <= 'z'; letter++){
            priority.put(letter, value);
            value++;
        }
        for(char letter = 'A'; letter <= 'Z'; letter++){
            priority.put(letter, value);
            value++;
        }
        return priority;
    }
}

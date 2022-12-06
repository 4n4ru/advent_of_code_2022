package day_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SupplyStacks2 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<ArrayList<Character>> stacks = new ArrayList<ArrayList<Character>>();
//        stacks.add(new ArrayList<>(Arrays.asList('Z', 'N')));
//        stacks.add(new ArrayList<>(Arrays.asList('M', 'C', 'D')));
//        stacks.add(new ArrayList<>(Arrays.asList('P')));
        stacks.add(new ArrayList<>(Arrays.asList('B', 'Q', 'C')));
        stacks.add(new ArrayList<>(Arrays.asList('R', 'Q', 'W', 'Z')));
        stacks.add(new ArrayList<>(Arrays.asList('B', 'M', 'R', 'L', 'V')));
        stacks.add(new ArrayList<>(Arrays.asList('C', 'Z', 'H', 'V', 'T', 'W')));
        stacks.add(new ArrayList<>(Arrays.asList('D', 'Z', 'H', 'B', 'N', 'V', 'G')));
        stacks.add(new ArrayList<>(Arrays.asList('H', 'N', 'P', 'C', 'J', 'F', 'V', 'Q')));
        stacks.add(new ArrayList<>(Arrays.asList('D', 'G', 'T', 'R', 'W', 'Z', 'S')));
        stacks.add(new ArrayList<>(Arrays.asList('C', 'G', 'M', 'N', 'B', 'W', 'Z', 'P')));
        stacks.add(new ArrayList<>(Arrays.asList('N', 'J', 'B', 'M', 'V', 'Q', 'F', 'P')));

        File input = new File("src/day_5/input.txt");
        Scanner scanner = new Scanner(input);
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] lineSplit = line.split(" ");
            int itemsToMove = Integer.parseInt(lineSplit[1]);
            int fromStack = Integer.parseInt(lineSplit[3]);
            int toStack = Integer.parseInt(lineSplit[5]);
            ArrayList<Character> temp = new ArrayList<>();
            for (int i = itemsToMove; i > 0; i--){
                char item = stacks.get(fromStack-1).remove(stacks.get(fromStack-1).size()-1);
                temp.add(item);
            }
            for (int i = itemsToMove; i > 0; i--){
                char item = temp.remove(temp.size()-1);
                stacks.get(toStack-1).add(item);
            }
        }
        for (int i = 0; i < 9; i++){
            char lastChar = stacks.get(i).get(stacks.get(i).size() -1);
            System.out.println(lastChar);
        }
    }
}

package day_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
// test if it shows up under my commits in github
public class CampCleanup {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("src/day_4/input.txt");
        Scanner scanner = new Scanner(input);
        String line;
        int fullyContainsCount = 0;
        while (scanner.hasNextLine()){
            line = scanner.nextLine();
            String[] elves = line.split(",");
            String[] elfOneSegment = elves[0].split("-");
            int elfOneLowerBoundary = Integer.parseInt(elfOneSegment[0]);
            int elfOneUpperBoundary = Integer.parseInt(elfOneSegment[1]);
            String[] elfTwoSegment = elves[1].split("-");
            int elfTwoLowerBoundary = Integer.parseInt(elfTwoSegment[0]);
            int elfTwoUpperBoundary = Integer.parseInt(elfTwoSegment[1]);
            boolean secondSegmentInFirst = elfOneLowerBoundary <= elfTwoLowerBoundary && elfOneUpperBoundary >= elfTwoUpperBoundary;
            boolean firstSegmentInSecond = elfTwoLowerBoundary <= elfOneLowerBoundary && elfTwoUpperBoundary >= elfOneUpperBoundary;
            if(secondSegmentInFirst || firstSegmentInSecond){
                fullyContainsCount++;
            }
        }
        System.out.println(fullyContainsCount);
    }
}

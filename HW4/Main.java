import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Collections;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Arrays;

class Main
{
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String str = new String();
        str = scanner.nextLine();
        str = str.toLowerCase().replaceAll("[^a-z0-9 ]","").replaceAll(" +", " ");
        ArrayList<String> strArr = new ArrayList<String>(Arrays.asList(str.split(" ")));
        TreeSet<String> strSet = new TreeSet<String>(strArr);
        System.out.println("Ascending order:");
        for (String v: strSet) {
            System.out.println(v + " appears " + Collections.frequency(strArr, v) + " times");
        }
        System.out.println("\nDescending order:");
        for (String v: strSet.descendingSet()) {
            System.out.println(v + " appears " + Collections.frequency(strArr, v) + " times");
        }
    }
};

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Collections;
import java.util.TreeSet;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

class Main
{
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String str = new String();
        str = scanner.nextLine();
        ArrayList<String> strArr = new ArrayList<String>(Arrays.asList(str.toLowerCase().replaceAll("[^a-z0-9 ]","").replaceAll(" +", " ").split(" ")));
        TreeSet<String> strSet = new TreeSet<String>(strArr); // For ordering, part of homework (so I don't use TreeMap)
        HashMap<String,Integer> strTable = new HashMap<String,Integer>(); // For counting
        for (String v: strArr) {
            Integer count = strTable.get(v);
            strTable.put(v, (count==null?0:count)+1); // Counting. If null, return 0
        }
        System.out.println("Ascending order:");
        for (String v: strSet) {
            System.out.println(v + " appears " + strTable.get(v) + " times");
        }
        System.out.println("\nDescending order:");
        for (String v: strSet.descendingSet()) {
            System.out.println(v + " appears " + strTable.get(v) + " times");
        }
    }
};

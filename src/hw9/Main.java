package hw9;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        1
//        11
//        21
//        1211
//        111221

        String string = "1";
        System.out.println(string);
        for (int i = 0; i < 6; i++) {
            String output = "";
            Deque<Map.Entry<String, Integer>> counter = countSymbols(string);
            Iterator<Map.Entry<String, Integer>> iterator = counter.iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Integer> entry = iterator.next();
                output = output + entry.getValue() + "" + entry.getKey();
            }
            string = output;
            System.out.println(output);
        }

    }

    private static Deque<Map.Entry<String, Integer>> countSymbols(String str) {
       Deque<Map.Entry<String, Integer>> counter = new ArrayDeque<>();
        char prevChar = 0;
        for (char c : str.toCharArray()) {

            String charString = String.valueOf(c);
            Map.Entry<String, Integer> entry;

            if (Objects.equals(prevChar, c)) {
                Map.Entry<String, Integer> oldEntry = counter.getLast();
                entry = Map.entry(charString, oldEntry.getValue() + 1);
                counter.removeLast();
            } else {
                entry = Map.entry(charString, 1);
            }

            counter.addLast(entry);
            prevChar = c;
        }
        return counter;
    }

}

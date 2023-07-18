package org.example;
import java.util.HashMap;
import java.util.Map;

public class Main {

        public class Main {

    public static void main(String[] args) {
        String[] rows = {"мама", "тато", "їж", "їжак", "желе"};
        List<Set<Character>> uniqueLettersList = findUniqueLetters(rows);

       
        for (int i = 0; i < rows.length; i++) {
            System.out.println("Unique letters " + (i + 1) + ": " + uniqueLettersList.get(i));
        }
    }

    public static List<Set<Character>> findUniqueLetters(String[] rows) {
        List<Set<Character>> uniqueLettersList = new ArrayList<>();

        for (String row : rows) {
            Map<Character, Integer> letterCounts = new HashMap<>();
            char[] characters = row.toCharArray();
            for (char c : characters) {
                if (Character.isLetter(c)) {
                    c = Character.toLowerCase(c);
                    letterCounts.put(c, letterCounts.getOrDefault(c, 0) + 1);
                }
            }

            Set<Character> uniqueLetters = new HashSet<>();
            for (char c : letterCounts.keySet()) {
                int occurrences = letterCounts.get(c);
                if (occurrences % 2 == 0) {
                    uniqueLetters.add(c);
                }
            }

            uniqueLettersList.add(uniqueLetters);
        }

        return uniqueLettersList;
    }
}

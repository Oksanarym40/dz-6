package org.example;
import java.util.HashMap;
import java.util.Map;

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
        Set<Character> uniqueCharactersForFirstTwoWords = new HashSet<>();

        for (String row : rows) {
            Map<Character, Integer> letterCounts = new HashMap<>();
            for (char c : row.toCharArray()) {
                if (Character.isLetter(c)) {
                    c = Character.toLowerCase(c);
                    letterCounts.put(c, letterCounts.getOrDefault(c, 0) + 1);
                }
            }

            boolean allEvenOccurrences = letterCounts.values().stream().allMatch(count -> count % 2 == 0);

            Set<Character> uniqueLetters = new HashSet<>();
            if (allEvenOccurrences) {
                uniqueLetters.addAll(letterCounts.keySet());
            }

            if (uniqueLettersList.size() < 2 && allEvenOccurrences) {
                uniqueCharactersForFirstTwoWords.addAll(uniqueLetters);
            }

            uniqueLettersList.add(uniqueLetters);
        }

        uniqueLettersList.set(0, uniqueCharactersForFirstTwoWords);
        uniqueLettersList.set(1, uniqueCharactersForFirstTwoWords);

        return uniqueLettersList;
    }
}

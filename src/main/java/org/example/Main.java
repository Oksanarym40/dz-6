package org.example;
import java.util.HashMap;
import java.util.Map;

public class Main {

        public static void main(String[]args){
            String[]rows={"мама","тато","їж","їжак","желе"};
            Map<Character,Integer>uniqueLetters=findUniqueLetters(rows);
            System.out.println("Unique letters:"+uniqueLetters.keySet());
        }

        public static Map<Character,Integer>findUniqueLetters(String[]rows){
            Map<Character,Integer>letterCounts=new HashMap<>();

            for(String row:rows){
                char[]characters=row.toCharArray();
                for(char c:characters){
                    letterCounts.put(c,letterCounts.getOrDefault(c,0)+1);
                }
            }

            Map<Character,Integer>uniqueLetters=new HashMap<>();
            for(char c:letterCounts.keySet()){
                if(letterCounts.get(c)==2){
                    uniqueLetters.put(c,2);
                }
            }

            return uniqueLetters;
        }
    }
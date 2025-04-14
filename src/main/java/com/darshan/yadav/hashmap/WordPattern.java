package com.darshan.yadav.hashmap;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
        WordPattern wordPattern = new WordPattern();
        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println(wordPattern.wordPattern(pattern, s)); // true

        pattern = "abba";
        s = "dog cat cat fish";
        System.out.println(wordPattern.wordPattern(pattern, s)); // false

        pattern = "aaaa";
        s = "dog cat cat dog";
        System.out.println(wordPattern.wordPattern(pattern, s)); // false
        pattern = "abba";
        s = "dog dog dog dog";
        System.out.println(wordPattern.wordPattern(pattern, s)); // false
    }
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(pattern.length() != words.length) return false;
        Map<Character, String> wordMap = new HashMap<>();
        Map<String, Character> charMap = new HashMap<>();
        for(int i =0; i< words.length; i++){
            Character currChar = pattern.charAt(i);
            if(wordMap.containsKey(currChar)){
                if(!words[i].equals(wordMap.get(currChar))) return false;
                if(!currChar.equals(charMap.get(words[i]))) return false;
            }else{
                wordMap.put(currChar, words[i]);
                charMap.put(words[i], currChar);
            }
        }
        return wordMap.size() == charMap.size();
    }

    /**
     * This is a more optimized version of the above code.
     * It uses only one map to store the index of the characters and words.
     * The time complexity is O(n) and space complexity is O(1).
     *
     * in for loop we use Integer insted of int because integer cache in Java.
     * You should check the implementation of Integer class in JDK and in that you can see a static class called
     * IntegerCache, it caches all integers in the range -127 to 128.
     * because of that it will work for all i < 128 but for all i >128 the value object
     * saved by both maps will be different. Hence the != check won't work as well.
     *
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPatternA2(String pattern, String s) {
        HashMap map_index = new HashMap();
        String[] words = s.split(" ");

        if (words.length != pattern.length())
            return false;

        for (Integer i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String w = words[i];

            if (!map_index.containsKey(c))
                map_index.put(c, i);

            if (!map_index.containsKey(w))
                map_index.put(w, i);

            if (map_index.get(c) != map_index.get(w))
                return false;
        }

        return true;
    }
}

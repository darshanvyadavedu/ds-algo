package com.darshan.yadav.hashmap;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> charMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            Integer count = charMap.getOrDefault(c, 0);
            charMap.put(c, count+1);
        }
        for(int i =0; i< t.length(); i++){
            Character c = t.charAt(i);
            if(charMap.containsKey(c)){
                Integer count = charMap.get(c);
                if(count == 1){
                    charMap.remove(c);
                }else {
                    charMap.put(c, count -1);
                }
            }else {
                return false;
            }
        }
        return charMap.size() == 0;
    }
}

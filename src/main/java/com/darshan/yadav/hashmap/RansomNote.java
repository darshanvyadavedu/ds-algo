package com.darshan.yadav.hashmap;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";

        RansomNote ransomNoteObj = new RansomNote();
        boolean result = ransomNoteObj.canConstructA1(ransomNote, magazine);
        System.out.println(result); // Output: true
    }
    public boolean canConstructA1(String ran, String mag) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c: mag.toCharArray()){
            map.putIfAbsent(c,0);
            map.put(c,map.get(c)+1);
        }
        for(char c: ran.toCharArray()){
            if(!map.containsKey(c) || map.get(c)<1)return false;
            map.put(c,map.get(c)-1);
        }
        return true;
    }

    public boolean canConstructA2(String ran, String mag) {
        int[] counts = new int[26];
        for(char c: mag.toCharArray()){
            counts[c-'a']++;
        }
        for(char c: ran.toCharArray()){
            counts[c-'a']--;
            if(counts[c-'a']<0)return false;
        }
        return true;
    }
}

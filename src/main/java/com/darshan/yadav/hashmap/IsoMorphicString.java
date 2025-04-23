package com.darshan.yadav.hashmap;

import java.util.HashMap;
import java.util.Map;

public class IsoMorphicString {

    public static void main(String[] args) {
        String s = "egg";
        String t = "add";

        IsoMorphicString isoMorphicString = new IsoMorphicString();
        boolean result = isoMorphicString.isIsomorphic(s, t);
        System.out.println(result); // Output: true
    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();
        if(s.length() != t.length()) return false;
        for(int i = 0; i< s.length(); i++){
            Character cs = s.charAt(i);
            Character ts = t.charAt(i);
            if(sMap.containsKey(cs) || tMap.containsKey(ts)){
                // I did not add highlighted code before and some test cases were failing.
                if(!ts.equals(sMap.get(cs))) return false;
                if(!cs.equals(tMap.get(ts))) return false;
            }
            sMap.put(cs, ts);
            tMap.put(ts, cs);
        }
        return true;
    }

    public boolean isIsomorphicOptimized(String s, String t) {
        int[] sMap = new int[256];
        int[] tMap = new int[256];
        for(int i = 0; i< s.length(); i++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if(sMap[sc] != tMap[tc]) return false;
            sMap[sc] = i+1;
            tMap[tc] = i+1;
        }
        return true;
    }

}

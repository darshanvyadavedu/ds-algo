package com.darshan.yadav.slidingwindow;

import java.util.*;

public class RepeatingDnaSequence {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> result = findRepeatedDnaSequences(s);
        System.out.println(result); // Output: [AAAAACCCCC, CCCCCAAAAA]
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        if(s.length() < 10) return new ArrayList<>();
        Set<Integer> hashValueSet = new HashSet<>();
        Set<String> repetedDnaSq = new HashSet<>();
        int base = 4;
        int prevHash =0;
        int currHash = 0;
        Map<Character, Integer> dnaMap = new HashMap<>();
        dnaMap.put('A', 1);
        dnaMap.put('C', 2);
        dnaMap.put('G', 3);
        dnaMap.put('T', 4);

        for(int i = 0; i< s.length(); i++){
            if(i ==0){
                while(i < 10){
                    int mag =  (int) Math.pow(base, 9-i);
                    currHash += mag * dnaMap.get(s.charAt(i++));
                }
                i--;
            }else {
                int mag =  (int) Math.pow(base, 9);
                int oldChar = dnaMap.get(s.charAt(i - 10));

                currHash =prevHash -  (mag * oldChar);
                currHash *= base;
                currHash += dnaMap.get(s.charAt(i));
            }

            if(hashValueSet.contains(currHash)){
                repetedDnaSq.add(s.substring(i-9, i+1));
            }else{
                hashValueSet.add(currHash);
            }
            prevHash = currHash;
        }
        return new ArrayList<>(repetedDnaSq);
    }
}

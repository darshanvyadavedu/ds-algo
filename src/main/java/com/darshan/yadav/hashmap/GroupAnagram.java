package com.darshan.yadav.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagram groupAnagram = new GroupAnagram();
        System.out.println(groupAnagram.groupAnagrams(strs));
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupAnagrams = new HashMap<>();
        for(int i = 0; i< strs.length; i++){
            String curr = strs[i];
            int[] cf = new int[26];
            for(int j =0; j< curr.length(); j++){
                cf[curr.charAt(j)-'a']++;
            }
            StringBuffer sb = new StringBuffer();
            for(int k =0; k< 26; k++){
                sb.append("#");
                sb.append(cf[k]);
            }
            String anagramKey = sb.toString();
            List<String> aList = groupAnagrams.getOrDefault(anagramKey, new ArrayList<>());
            aList.add(curr);
            groupAnagrams.put(anagramKey, aList);
        }
        return new ArrayList<>(groupAnagrams.values());
    }
}

package com.darshan.yadav.hashmap;

import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagram groupAnagram = new GroupAnagram();
        System.out.println(groupAnagram.groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupAnagrams = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String curr = strs[i];
            int[] cf = new int[26];
            for (int j = 0; j < curr.length(); j++) {
                cf[curr.charAt(j) - 'a']++;
            }
            StringBuffer sb = new StringBuffer();
            for (int k = 0; k < 26; k++) {
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

    int[] primes = {3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37,
            41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};

    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<Integer, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int key = 1;
            for (char c : s.toCharArray()) key *= primes[c - 'a'];
            if (map.containsKey(key)) map.get(key).add(s);
            else {
                List<String> value = new ArrayList<>();
                value.add(s);
                map.put(key, value);
                res.add(value);
            }
        }
        return res;
    }

    public List<List<String>> groupAnagrams3(String[] strs) {
        List<List<String>> groups = new ArrayList<>();
        Map<Integer, List<String>> anagramMap = new HashMap<>();
        for (String str : strs) { //str will iterate through all str so no str++;
            int id = getId(str);
            List<String> group = anagramMap.get(id);
            if (group == null) {
                group = new ArrayList<>();
                anagramMap.put(id, group);
            }
            group.add(str);
        }
        groups.addAll(anagramMap.values());
        return groups;
    }

    private int getId(String str) {
        int[] count = new int[26];
        for (char s : str.toCharArray()) {
            count[s - 'a']++;
        }
        return Arrays.hashCode(count);
    }

    public List<List<String>> groupAnagrams4(String[] strs) {
        HashMap<String, List<String>> anagramMap = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            List<String> value = anagramMap.getOrDefault(key, new ArrayList<>());
            value.add(str);
            anagramMap.put(key, value);
        }
        return new ArrayList<>(anagramMap.values());
    }
}

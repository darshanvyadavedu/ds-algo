package com.darshan.yadav.twopointer;

public class IsSubsequence {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        IsSubsequence isSubsequence = new IsSubsequence();
        System.out.println(isSubsequence.isSubsequence(s, t)); // Output: true

        s = "axc";
        t = "ahbgdc";
        System.out.println(isSubsequence.isSubsequence(s, t)); // Output: false
    }

    public boolean isSubsequence(String s, String t) {
        int si = 0, tj = 0;
        while(si < s.length() && tj < t.length()){
            if(s.charAt(si) == t.charAt(tj)){
                si++;
            }
            tj++;
        }
        return s.length() == si;
    }
}

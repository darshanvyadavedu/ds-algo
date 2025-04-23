package com.darshan.yadav.twopointer;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindromeA1(String s) {
        String s1 = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        return new StringBuilder(s1).reverse().toString().equals(s1);
    }

    public static  boolean  isPalindrome(String s) {
        int left =0; int right = s.length()-1;
        while(left < right){
            Character lc = s.charAt(left);
            Character rc = s.charAt(right);
            if(!isCharValid(lc)){
                left++;
                continue;
            }
            if(!isCharValid(rc)){
                right--;
                continue;
            }
            if (Character.toLowerCase(lc) != Character.toLowerCase(rc)) return false;
            left++; right--;
        }
        return true;
    }

    public static  boolean isCharValid(Character c ){
        return Character.isLetter(c) || Character.isDigit(c);
    }
}

package com.darshan.yadav.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HappyNumbers {
    public static void main(String[] args) {
        int n = 19;
        System.out.println(isHappyFloyd(n));
    }

    public static boolean isHappyMap(int n) {
        Set<Integer> hNums = new HashSet<>();
        int num = n;
        while(num != 1 && !hNums.contains(num)){
            int temp = num;
            int sum = 0;
            while(temp != 0){
                int qt = temp % 10;
                if(qt == 0) qt = 1;
                temp = temp / 10;
                sum +=  (qt * qt);
            }
            hNums.add(num);
            num = sum;
        }
        return num == 1;
    }


    public static boolean isHappyFloyd(int n) {
        int slow = n;
        int fast = getSumOfSquare(n);
        while(fast != 1 && slow != fast){
            slow = getSumOfSquare(slow);
            fast = getSumOfSquare(getSumOfSquare(fast));
        }
        return fast == 1;
    }

    public static int getSumOfSquare(int n ){
        int sum = 0;
        while(n != 0){
            int qt =  n % 10;
            n = n / 10;
            sum += qt* qt;
        }
        return sum;
    }
}

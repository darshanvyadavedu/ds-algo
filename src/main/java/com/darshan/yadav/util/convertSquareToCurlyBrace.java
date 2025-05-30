package com.darshan.yadav.util;

public class convertSquareToCurlyBrace {
    public static void main(String[] args) {
        String input = "[[2,29,20,26,16,28],[12,27,9,25,13,21],[32,33,32,2,28,14],[13,14,32,27,22,26],[33,1,20,7,21,7],[4,24,1,6,32,34]]";
        String output = convertSquareToCurly(input);
        System.out.println(output); // Output: {Hello, World!}
    }

    public static String convertSquareToCurly(String input) {
        return input.replace("[", "{").replace("]", "}");
    }
}

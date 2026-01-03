package com.dsa;

import java.sql.SQLOutput;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class LogicForgeTask2 {

    public static String PasswordRecoveryWindow(String log, String pattern ){
        //Edge case
        if (pattern.length() > log.length()){
            return "";
        }

        //Frequency of required characters
        Map<Character, Integer> required = new HashMap<>();
        for(char c : pattern.toCharArray()){
            required.put(c, required.getOrDefault(c,0) + 1);
        }

        //Sliding window
        Map<Character, Integer> window_count = new HashMap<>();
        int req_Unique = required.size(); // number of unique characters needed
        int formed = 0; // how many characters meet required frequency

        int left = 0;
        int min = Integer.MAX_VALUE;
        int start = 0;

        //Expand the window using right pointer
        for(int right = 0; right < log.length(); right++){
            char c = log.charAt(right);
            window_count.put(c, window_count.getOrDefault(c, 0) + 1);

            //if current character satisfies required frequency
            if(required.containsKey(c) && window_count.get(c).intValue() == required.get(c).intValue()){
                formed++;
            }

            //Try shrinking the window
            while ((left <= right) && (formed == req_Unique)){
                int window_size = right - left + 1;

                if (window_size < min){
                    min = window_size;
                    start = left;
                }

                //Remove leftmost characters
                char leftChar = log.charAt(left);
                window_count.put(leftChar, window_count.get(leftChar) - 1);

                //if removal breaks validity
                if(required.containsKey(leftChar) && window_count.get(leftChar) < required.get(leftChar)){
                    formed--;
                } left++;

            }
        }
        //return the result
        return min == Integer.MAX_VALUE ? "" : log.substring(start, start + min);
    }

    public static void main(String[] args){
        System.out.println(PasswordRecoveryWindow("ADOBECODEBANC","ABC"));
    }
}

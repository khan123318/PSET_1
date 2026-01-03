//package com.dsa;

public class LogicForgeTask1 {

    public static int[] getImpact(int[] contributions){
        int n = contributions.length;
        int[] impact = new int [n];
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        for (int i = 1; i < n; i++){
            left[i] = left[i - 1]*contributions[i-1];
        }

        right[n-1] = 1;
        for (int i = n - 2; i >=0; i--){
            right[i] = contributions[i + 1]*right[i+1];
        }

        for (int i = 0; i < n; i++) {
            impact[i] = left[i] * right[i];
        }
        return impact;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] test1 = {1, 2, 3, 4};
        System.out.println("Input: [1, 2, 3, 4]");
        System.out.println("Output: " + java.util.Arrays.toString(getImpact(test1)));
        System.out.println("Expected: [24, 12, 8, 6]\n");

        // Test Case 2
        int[] test2 = {2, 3, 4, 5};
        System.out.println("Input: [2, 3, 4, 5]");
        System.out.println("Output: " + java.util.Arrays.toString(getImpact(test2)));
        System.out.println("Expected: [60, 40, 30, 24]\n");

        // Test Case 3
        int[] test3 = {5};
        System.out.println("Input: [5]");
        System.out.println("Output: " + java.util.Arrays.toString(getImpact(test3)));
        System.out.println("Expected: [1]\n");

        // Test Case 4
        int[] test4 = {3, 4};
        System.out.println("Input: [3, 4]");
        System.out.println("Output: " + java.util.Arrays.toString(getImpact(test4)));
        System.out.println("Expected: [4, 3]");
    }
}



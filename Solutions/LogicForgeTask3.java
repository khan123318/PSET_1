//package com.dsa;

import java.util.Scanner;

public class LogicForgeTask3 {

    public Double BalancedPerformanceScore(int[] ScoresA, int[] ScoresB){
        int m = ScoresA.length;
        int n = ScoresB.length;
        int total = m + n;

        int i = 0, j = 0;
        int prev = 0, curr = 0;

        for(int count = 0; count <= total/2; count++){
            prev = curr;
            if(i < m && (j >= n || ScoresA[i]<=ScoresB[j])){
                curr = ScoresA[i];
                i++;
            }
            else{
                curr = ScoresB[j];
                j++;
            }
        }
        if(total%2 == 1){
            return (double)curr;
        }
        return (prev + curr)/2.0;
    }
    public static void main(String[] args) {
        
        int[] ScoresA = {1, 3, 5, 7};
        int[] ScoresB = {2, 4, 6, 8};

        LogicForgeTask3 obj = new LogicForgeTask3();

        Double result = obj.BalancedPerformanceScore(ScoresA, ScoresB);

        System.out.println("Balanced Performance Score (Median): " + result);
    }
}

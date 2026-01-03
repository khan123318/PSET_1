//package com.dsa;

public class LogicForgeTask4 {
    public Integer InventorySearch(int[][] matrix, int k){
        int n = matrix.length;
        int smallest = matrix[0][0];
        int largest = matrix[n-1][n-1];

        while(smallest < largest){
            int mid = smallest + (largest - smallest)/2;
            int count = 0;

            int row = n-1;
            int col = 0;

            while(row>=0 && col < n){
                if(matrix[row][col] <= mid){
                    count += row + 1;
                    col++;
                }
                else{
                    row--;
                }
            }
            if (count < k){
                smallest = mid + 1;
            } else{
                largest = mid;
            }
        } return smallest;

    }
    public static void main(String[] args) {
        LogicForgeTask4 solver = new LogicForgeTask4();

        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 8;

        int result = solver.InventorySearch(matrix, k);
        System.out.println("The " + k + "th smallest element is: " + result);
    }
}


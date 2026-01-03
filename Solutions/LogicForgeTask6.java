//package com.dsa;

public class LogicForgeTask6 {
    public static void TowerOfHanoi(int N, char from_rod, char aux_rod, char to_rod){
        if(N==1){
            System.out.println("Disc" + " " + "moved from" + " " + from_rod + " " + "to" +" " + to_rod);
            return;
        }
        TowerOfHanoi(N-1,from_rod,to_rod,aux_rod);
        TowerOfHanoi(1,from_rod,aux_rod,to_rod);
        TowerOfHanoi(N-1,aux_rod,from_rod,to_rod);
    }

    public static void main(String[] args){
        TowerOfHanoi(4,'A','B','C');
    }
}

package com.dsa;

import java.util.*;

public class LogicForgeTask5 {
    public static List<String> ValidParenthesis(String s){
        //BFS used here
        List<String> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(s);
        visited.add(s);

        boolean found = false;
        while(!queue.isEmpty()){
            String curr = queue.poll();
            if(isValid(curr)){
                result.add(curr);
                found = true;
            }
            if (found) continue;
            for (int i = 0; i < curr.length(); i++) {
                char c = curr.charAt(i);
                if (c != '(' && c != ')') continue;

                String next = curr.substring(0, i) + curr.substring(i + 1);
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.add(next);
                }
            }
        } return result;

    }
    private static Boolean isValid(String s){
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')') {
                if (count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {

        String[] tests = {"()())()"};

        for (String test : tests) {
            System.out.println("Input: " + test);
            List<String> ans = ValidParenthesis(test);

            System.out.println("Output:");
            for (String s : ans) {
                System.out.println(s);
            }
        }
    }
}


package com.codingtest.codingtest.inflearn.chapter7_재귀_Tree와Graph_DFS_BFS_기초;

import java.util.Scanner;

/**
 설명

 피보나치수열 을 재귀함수로 작성 N은 항의 수

 1 1 2 3 5 8

 */
public class 피보나치수열_재귀 {

    static int[] arr;

    public static void main(String[] args) {
        int n = 45;
        arr = new int[n + 1];
        solution(n);
        for (int i = 1; i <= n; i++) {
            System.out.println(arr[i] + " ");
        }
    }


    public static int solution(int input) {
        if (arr[input] > 0) {
            return arr[input];
        }
        if (input == 1 || input == 2) {
            return arr[input] = 1;
        }
        return arr[input] = solution(input - 2) + solution(input - 1);

    }
}

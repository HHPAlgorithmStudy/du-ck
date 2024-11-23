package com.codingtest.codingtest.inflearn.chapter7_재귀_Tree와Graph_DFS_BFS_기초;

import java.util.Scanner;

/**
 설명

 10진수 N이 입력되면 재귀함수를 2진수로 출력하는 프로그램

 */
public class 이진함수_재귀 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input1 = in.nextInt();

        solution(input1);
    }


    public static void solution(int input) {
        if (input == 0) {
            return;
        }
        solution(input / 2);    // 11 5 2 1
        System.out.print(input % 2);
    }
}

package com.codingtest.codingtest.inflearn.chapter7_재귀_Tree와Graph_DFS_BFS_기초;

import java.util.Scanner;

/**
 설명

 N이 입력되면 N! 을 재귀함수로 작성

 */
public class 팩토리얼_재귀 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input1 = in.nextInt();

        System.out.println(solution(input1));
    }


    public static int solution(int input) {

        if (input == 1) {
            return 1;
        } else {
            // 5 4 3 2 1
            return input * solution(input - 1);
        }
    }
}

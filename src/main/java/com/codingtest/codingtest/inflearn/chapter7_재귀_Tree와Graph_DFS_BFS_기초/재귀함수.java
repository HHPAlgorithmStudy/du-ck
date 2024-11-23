package com.codingtest.codingtest.inflearn.chapter7_재귀_Tree와Graph_DFS_BFS_기초;

import java.util.Scanner;

/**
 설명

 N이 입력되면 재귀함수를 이용하여 1부터 N 까지 출력하는 프로그램을 작성하시오

 */
public class 재귀함수 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input1 = in.nextInt();

        solution(input1);
    }


    public static void solution(int input) {
        if (input == 0) {
            return;
        }
        /**
         * 3 을 입력하면 3 2 1 이 아닌
         * 1 2 3 으로 출력이 된다.
         * 재귀함수형식으로 호출을 하면 스택형식으로 쌓이게 되서
         * sout 까지 가지 않고 solution 을 호출 했다는 것만 스택에 쌓이게 되고
         * 그에따라 input - 1 만 실행이 먼저 된다.
         * 그러다 input 0 이 되어 쌓이는게 끝나면
         * solution (1) 부터 실행 되는 것이다. (스택 LIFO )
         */
        solution(input - 1);
        System.out.print(input + " ");
    }
}

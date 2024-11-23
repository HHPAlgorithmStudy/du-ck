package com.codingtest.codingtest.inflearn.chapter7_재귀_Tree와Graph_DFS_BFS_기초;

import java.util.Scanner;

/**
 설명

 자연수 N 이 주어지면 1부터 N까지의 원소를 갖는 집합의
 부분집합을 모두 출력하는 프로그램을 작성


 자연수 N(1<=N<=10) 이 주어진다.

 공집합은 출력하지 않는다.

 입력예제 1
 3

 출력예제 1
 1 2 3
 1 2
 1 3
 1
 2 3
 2
 3


 */
public class 부분집합구하기 {
    static int n;
    static boolean[] check;

    public static void main(String[] args) {
        n = 3;
        check = new boolean[n + 1];
        solution(1);
    }


    public static void solution(int input) {
        if (input == n + 1) {
            // 종착점에 왔다면
            String msg = "";
            for (int i = 1; i <= n; i++) {
                if (check[i]) {
                    msg += i + " ";
                }
            }
            System.out.println(msg);
        } else {
            //종착점에 오지 않았다면
            // 재귀를 2번쓰는데 각각 사용한다와 안한다는 외울것.

            // 사용한다.
            //사용 하므로 check 배열에 true 처리
            check[input] = true;
            solution(input + 1);    // 왼쪽으로 뻗음  (사용한다의 왼쪽)

            //사용 안한다
            // 사용 안하므로 check 배열에 false 처리
            check[input] = false;
            solution(input + 1);    // 오른쪽으로 뻗음 (사용 안한다의 오른쪽)
        }
    }
}

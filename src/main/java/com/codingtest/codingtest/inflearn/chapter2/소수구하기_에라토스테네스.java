package com.codingtest.codingtest.inflearn.chapter2;


import java.util.Scanner;

/**
 설명

 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.

 만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.


 입력
 첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.


 출력
 첫 줄에 소수의 개수를 출력합니다.


 예시 입력 1
 20

 예시 출력
 8

 */
public class 소수구하기_에라토스테네스 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input1 = in.nextInt();

        System.out.println(solution(input1));
    }


    public static int solution(int input) {
        int[] arr = new int[input + 1];

        int count = 0;
        for (int i = 2; i <= input; i++) {
            // 0 이면 체크
            if (arr[i] == 0) {
                count++;
                // 뒤에 배열에서 2의 배수들 체크
                for (int j = i; j <= input; j += i) {
                    arr[j] = 1;
                }
            }
        }
        return count;
    }
}

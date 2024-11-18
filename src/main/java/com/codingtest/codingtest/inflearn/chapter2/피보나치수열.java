package com.codingtest.codingtest.inflearn.chapter2;


import java.util.Scanner;

/**
 설명

 1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.

 2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.


 입력
 첫 줄에 총 항수 N(3<=N<=45)이 입력된다.


 출력
 첫 줄에 피보나치 수열을 출력합니다

 예시입력
 10

 예시출력
 1 1 2 3 5 8 13 21 34 55

 */
public class 피보나치수열 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input1 = in.nextInt();

        for (int x : solution(input1)) {
            System.out.print(x + " ");
        }
    }


    public static int[] solution(int input) {
        int[] answer = new int[input];

        int item = 1;
        answer[0] = item;
        answer[1] = item;

        //1 1 2 3 5 8 13 21 34 55
        for (int i = 2; i < input; i++) {
            answer[i] = answer[i - 1] + answer[i - 2];
        }
        return answer;
    }

    /**
     * 배열 없이
     * @param input
     * @return
     */
    public static void solution2(int input) {
        int a = 1;
        int b = 1;
        int c = 0;
        System.out.print(a + " " + b + " ");
        for (int i = 2; i < input; i++) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }

    }
}

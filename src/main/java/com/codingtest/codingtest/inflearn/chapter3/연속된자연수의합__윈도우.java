package com.codingtest.codingtest.inflearn.chapter3;



import java.util.Scanner;

/**
 설명

 N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.

 만약 N=15이면

 7+8=15

 4+5+6=15

 1+2+3+4+5=15

 와 같이 총 3가지의 경우가 존재한다.


 입력
 첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.


 출력
 첫 줄에 총 경우수를 출력합니다.


 예시 입력 1

 15

 예시 출력 1

 3


 */
public class 연속된자연수의합__윈도우 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input1 = in.nextInt();


        //System.out.println(solution(input1));
        System.out.println(solution2(input1));
    }


    public static int solution(int sum) {
        /**
         * 만약 N=15이면
         *
         *  7+8=15
         *
         *  4+5+6=15
         *
         *  1+2+3+4+5=15
         */
        int answer = 0;
        int tmp = 0;
        int point = 1;

        for (int i = 0; i < sum/2 + 1; i++) {
            tmp += point + i;
            //System.out.println("point : " + point + " i : " + i + " tmp : " + tmp);
            if (tmp == sum) {
                answer++;
                tmp = 0;
                //System.out.println("add!!");
            }
            if (i == sum - 1) {
                i = 0;
                point++;
            }
            if (tmp > sum) {
                tmp = 0;
                point++;
                i = 0;
            }
            if (point == sum - 1) {
                break;
            }
        }
        return answer;
    }

    public static int solution2(int sum) {
        int lt = 0;
        int rt = 0;
        int answer = 0;

        // 받은 수의 절반을 배열에 담음.
        int length = sum / 2 + 1;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = i + 1;
        }

        int tmp = 0;
        while (rt < arr.length) {
            tmp += arr[rt];
            if (tmp == sum) {
                answer++;
                lt++;
                rt = lt;
                tmp = 0;
            } else if (tmp > sum) {
                lt++;
                rt = lt;
                tmp = 0;
            } else {
                rt++;
            }
        }
        return answer;
    }
}

package com.codingtest.codingtest.inflearn.chapter6_정렬_이분검색_결정알고리즘;

import java.util.Scanner;

/**
 설명

 N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.

 정렬하는 방법은 버블정렬입니다.


 입력
 첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.

 두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.


 출력
 오름차순으로 정렬된 수열을 출력합니다.


 예시 입력 1

 6
 13 5 11 7 23 15
 예시 출력 1

 5 7 11 13 15 23

 */
public class 버블정렬 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input1 = in.nextInt();
        int[] arr = new int[input1];
        for (int i = 0; i < input1; i++) {
            arr[i] = in.nextInt();
        }

        for (int x : solution(arr)) {
            System.out.print(x + " ");
        }
    }


    public static int[] solution(int[] arr) {

        // 선택정렬과 달리 별다른 idx 가 필요하지 않다.
        // i 가 0 이면
        // j 가 0,1 비교 -> 1,2 비교 -> 2,3 비교 하는식으로 반복되는 형식
        // 어차피 맨 뒤에는 가장 큰수가 들어가므로
        // for문 조건에서 length - 1 을 해도 상관이 없다.

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }
}

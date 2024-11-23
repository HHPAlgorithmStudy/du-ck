package com.codingtest.codingtest.inflearn.chapter6_정렬_이분검색_결정알고리즘;

import java.util.Scanner;

/**
 선택 정렬
 설명

 N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.

 정렬하는 방법은 선택정렬입니다.


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
public class 선택정렬 {

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

        //저장할 idx를 하나 만들어놓고 i를 저장.
        //2중 for문을 돌면서
        // j for문이 끝까지 돌면서
        // 더 작은 수가 있다면 해당 index 를 idx 에 저장.
        // j for문이 끝나면 arr[idx] 와 arr[i] 의 위치를 바꾼다.

        int idx = 0;

        for (int i = 0; i < arr.length; i++) {
            idx = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[idx] > arr[j]) {
                    idx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }

        return arr;
    }
}

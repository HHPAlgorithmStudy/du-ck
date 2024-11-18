package com.codingtest.codingtest.inflearn.chapter3;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 설명

 A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.


 입력
 첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.

 두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.

 세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.

 네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.

 각 집합의 원소는 1,000,000,000이하의 자연수입니다.


 출력
 두 집합의 공통원소를 오름차순 정렬하여 출력합니다.


 예시 입력 1

 5
 1 3 9 5 2
 5
 3 2 5 7 8

 예시 출력 1

 2 3 5


 */
public class 공통원소구하기 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input1 = in.nextInt();
        int[] arr1 = new int[input1];
        for (int i = 0; i < input1; i++) {
            arr1[i] = in.nextInt();
        }

        int input2 = in.nextInt();
        int[] arr2 = new int[input2];
        for (int i = 0; i < input2; i++) {
            arr2[i] = in.nextInt();
        }
        solution2(arr1, arr2).stream().forEach(m -> System.out.print(m + " "));
    }


    public static List<Integer> solution(int[] arr1, int[] arr2) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {

            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    answer.add(arr2[j]);
                    break;
                }
            }
        }
        return answer.stream().sorted().collect(Collectors.toList());
    }

    public static List<Integer> solution2(int[] arr1, int[] arr2) {
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int p1 = 0;
        int p2 = 0;

        while (p1 < arr1.length && p2 < arr2.length) {
            if (arr1[p1] < arr2[p2]) {
                p1++;
            } else if (arr1[p1] > arr2[p2]) {
                p2++;
            } else {
                answer.add(arr1[p1]);
                p1++;
                p2++;
            }
        }

        return answer;
    }
}

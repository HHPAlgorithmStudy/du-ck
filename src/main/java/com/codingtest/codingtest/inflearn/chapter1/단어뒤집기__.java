package com.codingtest.codingtest.inflearn.chapter1;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * 설명
 *
 * N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
 *
 * 두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.
 *
 *
 * 출력
 * N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.
 *
 * 예시입력
 *
 * 3
 * good
 * Time
 * Big
 *
 * 예시출력
 * doog
 * emiT
 * giB
 *
 */
public class 단어뒤집기__ {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input1 = in.nextInt();

        String[] arr = new String[input1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.next();
        }
        //solution(arr);
        solution2(arr);
    }

    /**
     * 전체 뒤집기
     * @param arr
     */
    public static void solution(String[] arr) {
        StringBuilder sb;
        for (int i = 0; i < arr.length; i++) {
            sb = new StringBuilder(arr[i]);
            System.out.println(sb.reverse());
        }
    }

    /**
     * 하나하나 (조건에따라) 뒤집어야 할 경우
     */
    public static void solution2(String[] arr) {
        List<String> answer = new ArrayList<>();
        for (String item : arr) {   //Good
            char[] charArr = item.toCharArray();    // G  o  o  d
            String strAnswer = "";
            for (int i = charArr.length - 1; i >= 0; i--) {
                strAnswer += charArr[i];
            }
            answer.add(strAnswer);
        }

        answer.stream().forEach(item -> System.out.println(item));
    }

    public static void solution3(String[] arr) {
        List<String> answer = new ArrayList<>();
        for (String item : arr) {
            char[] charArr = item.toCharArray();
            int lt = 0;
            int rt = item.length() - 1;
            while (lt < rt) {
                char tmp = charArr[lt];
                charArr[lt] = charArr[rt];
                charArr[rt] = tmp;
                lt++;
                rt--;
            }
            answer.add(String.valueOf(charArr));
        }
        answer.stream().forEach(item -> System.out.println(item));
    }
}

package com.codingtest.codingtest.inflearn;


import java.util.Scanner;

/**
 *
 *설명
 *
 * 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
 *
 * 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.
 *
 *
 * 출력
 * 첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.
 *
 *
 * 예시입력
 *
 * a#b!GE*T@S
 *
 * 예시출력
 *
 * S#T!EG*b@a
 */
public class 특정문자뒤집기 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input1 = in.nextInt();

        String[] arr = new String[input1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.next();
        }
        solution(arr);
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


}

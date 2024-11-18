package com.codingtest.codingtest.inflearn.chapter1;




import java.util.Scanner;

/**
 설명

 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.


 입력
 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.

 문자열의 길이는 100을 넘지 않는다.


 출력
 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.

 예시입력
 teachermode e

 예시출력
 1 0 1 2 1 0 1 2 2 1 0

 */
public class 짧은문자거리__ {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input1 = in.nextLine();
        String input2 = in.nextLine();

        System.out.println(String.join(" ", solution(input1, input2.charAt(0))));
    }


    public static String[] solution(String input1, char c) {
        int[] arr = new int[input1.length()];
        String[] answer = new String[input1.length()];

        int count = 1000;
        for (int i = 0; i < input1.length(); i++) {
            if (input1.charAt(i) == c) {
                count = 0;
            } else {
                count++;
            }
            arr[i] = count;
        }

        count = 1000;
        for (int i = input1.length() - 1; i >= 0; i--) {
            if (input1.charAt(i) == c) {
                count = 0;
            } else {
                count++;
            }
            answer[i] = String.valueOf(Math.min(count, arr[i]));
        }
        return answer;
    }
}

package com.codingtest.codingtest.inflearn.chapter2;




import java.util.Arrays;
import java.util.Scanner;

/**
 설명

 N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.

 (첫 번째 수는 무조건 출력한다)


 입력
 첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.


 출력
 자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.

 예시입력1
 6
 7 3 9 5 6 12

 예시출력1
 7 9 6 12

 */
public class 큰수출력하기 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input1 = in.nextInt();

        int[] arr = new int[input1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(solution(arr));
    }


    public static String solution(int[] arr) {
        String answer = "";
        int[] newArr = Arrays.copyOf(arr, arr.length + 1);
        newArr[newArr.length - 1] = Integer.MIN_VALUE;

        answer = newArr[0] + " ";
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                answer += (arr[i + 1] + " ");
            }
        }

        return answer;
    }
}

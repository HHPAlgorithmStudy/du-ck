package com.codingtest.codingtest.inflearn.chapter2;




import java.util.Arrays;
import java.util.Scanner;

/**
 설명

 선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는

 선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요. (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)


 입력
 첫 줄에 정수 N(5<=N<=100,000)이 입력된다. 그 다음줄에 N명의 학생의 키가 앞에서부터 순서대로 주어진다.


 출력
 선생님이 볼 수 있는 최대학생수를 출력한다.

 예시입력1
 8
 130 135 148 140 145 150 150 153


 예시출력1
 5

 */
public class 보이는학생 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input1 = in.nextInt();

        int[] arr = new int[input1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(solution(arr));
    }


    public static int solution(int[] arr) {
        int count = 0;
        int size = Integer.MIN_VALUE;
        int[] newArr = Arrays.copyOf(arr, arr.length + 1);
        newArr[newArr.length - 1] = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (size < newArr[i]) {
                size = newArr[i];
                count++;
            }
        }

        return count;
    }
}

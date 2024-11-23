package com.codingtest.codingtest.inflearn.chapter6_정렬_이분검색_결정알고리즘;

import java.util.Arrays;
import java.util.Scanner;

/**


 */
public class 이분검색_바이너리서치 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input1 = in.nextInt();
        int input2 = in.nextInt();
        int[] arr = new int[input1];
        for (int i = 0; i < input1; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(solution(arr, input2));
    }


    public static int solution(int[] arr, int findItem) {
        int answer = 0;
        Arrays.sort(arr);

        int lt = 0;
        int rt = arr.length - 1;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (arr[mid] == findItem) {
                answer = mid + 1;
                break;
            }
            if (arr[mid] > findItem) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }

        }
        return answer;
    }
}

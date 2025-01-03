package com.codingtest.codingtest.프로그래머스.스택_큐.level1;


import java.util.*;


/**
 * 문제 설명
 * 배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다. 이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다. 단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다. 예를 들면,
 *
 * arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
 * arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
 * 배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.
 */


/**
 * 제한사항
 * 배열 arr의 크기 : 1,000,000 이하의 자연수
 * 배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수
 */

/**
 * 입출력 예
 * arr	                answer
 * [1,1,3,3,0,1,1]	    [1,3,0,1]
 * [4,4,4,3,3]	        [4,3]
 * 입출력 예 설명
 * 입출력 예 #1,2
 * 문제의 예시와 같습니다.
 */

public class 같은숫자는싫어 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.solution(new int[]{2,2,3,3});
        System.out.println("result :: " + result);
    }


    static class Solution {
        public int[] solution(int []arr) {
            int[] answer = {};
            Queue<Integer> queue = new LinkedList<>();

            // 첫번째 숫자는 무조건 offer
            queue.offer(arr[0]);

            for (int i = 0; i < arr.length - 1; i++) {
                //앞자리와 비교하여 다를경우만 offer
                if (arr[i] != arr[i + 1]) {
                    queue.offer(arr[i + 1]);
                }
            }

            //queue size 만큼 생성
            answer = new int[queue.size()];

            //queue 가 비워질때까지 answer 에 담는다
            for(int i = 0; !queue.isEmpty(); i++){
                answer[i] = queue.poll();
            }

            return answer;
        }
    }
}

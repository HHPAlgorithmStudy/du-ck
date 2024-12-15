package com.codingtest.codingtest.프로그래머스.연습문제.level2;


import java.util.Stack;

/**
 문제 설명
 정수로 이루어진 배열 numbers가 있습니다. 배열 의 각 원소들에 대해 자신보다 뒤에 있는 숫자 중에서 자신보다 크면서 가장 가까이 있는 수를 뒷 큰수라고 합니다.
 정수 배열 numbers가 매개변수로 주어질 때,
 모든 원소에 대한 뒷 큰수들을 차례로 담은 배열을 return 하도록 solution 함수를 완성해주세요.
 단, 뒷 큰수가 존재하지 않는 원소는 -1을 담습니다.

 제한사항
 4 ≤ numbers의 길이 ≤ 1,000,000
 1 ≤ numbers[i] ≤ 1,000,000

 입출력 예
 numbers	            result
 [2, 3, 3, 5]	        [3, 5, 5, -1]
 [9, 1, 5, 3, 6, 2]	    [-1, 5, 6, 6, -1, -1]

 입출력 예 설명
 입출력 예 #1
 2의 뒷 큰수는 3입니다. 첫 번째 3의 뒷 큰수는 5입니다. 두 번째 3 또한 마찬가지입니다. 5는 뒷 큰수가 없으므로 -1입니다. 위 수들을 차례대로 배열에 담으면 [3, 5, 5, -1]이 됩니다.

 입출력 예 #2
 9는 뒷 큰수가 없으므로 -1입니다. 1의 뒷 큰수는 5이며, 5와 3의 뒷 큰수는 6입니다. 6과 2는 뒷 큰수가 없으므로 -1입니다. 위 수들을 차례대로 배열에 담으면 [-1, 5, 6, 6, -1, -1]이 됩니다.
 */

public class 뒤에있는큰수찾기 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[] result = solution.solution(new int[]{2, 3, 3, 5});    //3, 5, 5, -1
        int[] result = solution.solution2(new int[]{9, 1, 5, 3, 6, 2});    // -1, 5, 6, 6, -1, -1
        System.out.println("result :: " + result);     //false
    }

    static class Solution {

        // 잘못된 풀이

        // >> 완전탐색? 투포인터 풀이..
        // >> 테스트 20부터 실패.. (시간초과)


        // 2중 포문과 투 포인터의 차이??

        //  아래 풀이는 그냥 투포인터를 이용한
        // 2중 포문
        //

        public int[] solution(int[] numbers) {
            int[] answer = new int[numbers.length];

            int lt = 0;
            int rt = 1;

            while (lt < numbers.length) {
                if (rt == numbers.length) {
                    answer[lt] = -1;
                    lt++;
                    rt = lt + 1;
                } else if (numbers[lt] >= numbers[rt]) {
                    rt++;
                } else {
                    answer[lt] = numbers[rt];
                    lt++;
                    rt = lt + 1;
                }
            }
            answer[answer.length - 1] = -1;

            return answer;
        }

        public int[] solution2(int[] numbers) {
            int[] answer = new int[numbers.length];
            Stack<Integer> stack = new Stack<>(); // 인덱스를 저장하는 스택

            // 배열을 순회하며 오른쪽 큰 수를 찾는다
            for (int i = 0; i < numbers.length; i++) {
                // 현재 숫자가 스택에 저장된 인덱스의 숫자보다 크다면 큰 수를 발견한 것
                while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                    answer[stack.pop()] = numbers[i]; // 스택에서 꺼낸 인덱스의 값 갱신
                }
                stack.push(i); // 현재 인덱스를 스택에 저장
            }

            // 스택에 남아 있는 인덱스들은 큰 수가 없으므로 -1로 설정
            while (!stack.isEmpty()) {
                answer[stack.pop()] = -1;
            }

            return answer;
        }
    }
}
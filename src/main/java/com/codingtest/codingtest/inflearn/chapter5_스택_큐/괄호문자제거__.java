package com.codingtest.codingtest.inflearn.chapter5_스택_큐;

import java.util.Scanner;
import java.util.Stack;

/**
 설명

 입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.


 입력
 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.


 출력
 남은 문자만 출력한다.


 예시 입력 1

 (A(BC)D)EF(G(H)(IJ)K)LM(N)
 예시 출력 1

 EFLM

 */
public class 괄호문자제거__ {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input1 = in.next();

        System.out.println(solution(input1));
    }


    public static String solution(String input1) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for (char x : input1.toCharArray()) {
            if (x == ')') {
                while (stack.pop() != '(');
            } else {
                stack.push(x);
            }
        }

        for (int i = 0; i < stack.size(); i++) {
            answer += stack.get(i);
        }

        return answer;
    }
}

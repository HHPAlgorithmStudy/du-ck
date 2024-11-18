package com.codingtest.codingtest.inflearn.chapter1;





import java.util.Scanner;

/**
 설명

 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는

 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.

 단 반복횟수가 1인 경우 생략합니다.


 입력
 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.


 출력
 첫 줄에 압축된 문자열을 출력한다.


 예시입력1
 KKHSSSSSSSE

 예시출력1
 K2HS7E

 예시입력2
 KSTTTSEEKFKKKDJJGG

 예시출력2
 KST3SE2KFK3DJ2G2

 */
public class 문자열압축__ {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input1 = in.nextLine();
        System.out.println(solution(input1));
    }


    public static String solution(String input1) {

        // 여기서 i+1 를 비교하기때문에 input1  맨끝에 빈 문자열을 더한다.
        // 해당 알고리즘이 통하기 위해
        // 그 대신 for 문 조건을 -1 한다
        input1 += " ";

        String answer = "";
        int count = 1;

        for (int i = 0; i < input1.length() - 1; i++) {
            if (input1.charAt(i) == input1.charAt(i + 1)) {
                count++;
            } else {
                answer += (String.valueOf(input1.charAt(i)));
                if (count > 1) {
                    answer += count;
                }
                count = 1;
            }

        }
        return answer;
    }
}

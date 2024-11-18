package com.codingtest.codingtest.inflearn.chapter2;




import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 설명

 A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.

 가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.

 예를 들어 N=5이면


 회수      1   2   3   4   5
 ----------------------------
 A의 정보  2   3   3   1   3
 B의 정보  1   1   2   2   3
 승자      A   B   A   B   D


 두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.


 입력
 첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.

 두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.

 세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.


 출력
 각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.

 예시입력
 5
 2 3 3 1 3
 1 1 2 2 3

 예시출력
 A
 B
 A
 B
 D

 */
public class 가위바위보 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input1 = in.nextInt();

        int[] player1 = new int[input1];
        int[] player2 = new int[input1];
        for (int i = 0; i < player1.length; i++) {
            player1[i] = in.nextInt();
        }
        for (int i = 0; i < player2.length; i++) {
            player2[i] = in.nextInt();
        }
        solution(player1, player2).stream().forEach(m -> System.out.println(m));
    }


    public static List<String> solution(int[] player1, int[] player2) {
        List<String> answer = new ArrayList<>();
        //1:가위, 2:바위, 3:보
        //가위 vs 바위 = 1 2-
        //가위 vs 보 = 1- 3
        //바위 vs 보 = 2 3-
        // 빼기를 했을때 1차이면 큰숫자
        // 2차이면 작은숫자가 승리
        for (int i = 0; i < player1.length; i++) {
            if (Math.abs(player1[i] - player2[i]) == 2) {
                answer.add(player1[i] < player2[i] ? "A" : "B");
            } else if (Math.abs(player1[i] - player2[i]) == 1) {
                answer.add(player1[i] > player2[i] ? "A" : "B");
            } else {
                answer.add("D");
            }
        }
        return answer;
    }
}

package com.codingtest.codingtest.inflearn.chapter4_해쉬_정렬지원set;



import java.util.*;
import java.util.stream.Collectors;

/**
 설명

 현수는 1부터 100사이의 자연수가 적힌 N장의 카드를 가지고 있습니다. 같은 숫자의 카드가 여러장 있을 수 있습니다.

 현수는 이 중 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록하려고 합니다. 3장을 뽑을 수 있는 모든 경우를 기록합니다.

 기록한 값 중 K번째로 큰 수를 출력하는 프로그램을 작성하세요.

 만약 큰 수부터 만들어진 수가 25 25 23 23 22 20 19......이고 K값이 3이라면 K번째 큰 값은 22입니다.


 입력
 첫 줄에 자연수 N(3<=N<=100)과 K(1<=K<=50) 입력되고, 그 다음 줄에 N개의 카드값이 입력된다.


 출력
 첫 줄에 K번째 수를 출력합니다. K번째 수가 존재하지 않으면 -1를 출력합니다.


 예시 입력 1

 10 3
 13 15 34 23 45 65 33 11 26 42

 예시 출력 1
 143

 */
public class K번째큰수 {

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


    public static int solution(int[] cards, int k) {
        int answer = -1;
        // 3장 카드를 뽑는 모든 경우의 수를 구한다.
        // 3장의 합을 나열 한 뒤 k번째 큰 수를 구한다
        HashSet<Integer> set = new HashSet<>();
        //3중 for문을 돌리면 됨.
        for (int i = 0; i < cards.length; i++) {
            for (int j = i + 1; j < cards.length; j++) {
                for (int l = j + 1; l < cards.length; l++) {
                    set.add(cards[i] + cards[j] + cards[l]);
                }
            }
        }

        set = set.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int count = 0;
        for (Integer x : set) {
            count++;
            if (count == k) {
                answer = x;
            }

        }
        return answer;
    }
}

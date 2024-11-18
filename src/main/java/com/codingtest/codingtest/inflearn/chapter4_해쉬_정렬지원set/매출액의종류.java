package com.codingtest.codingtest.inflearn.chapter4_해쉬_정렬지원set;

import java.util.*;

/**
 설명

 현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를

 각 구간별로 구하라고 했습니다.

 만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면

 20 12 20 10 23 17 10

 각 연속 4일간의 구간의 매출종류는

 첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.

 두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.

 세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.

 네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.

 N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별

 매출액의 종류를 출력하는 프로그램을 작성하세요.


 입력
 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.

 두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.


 출력
 첫 줄에 각 구간의 매출액 종류를 순서대로 출력합니다.


 예시 입력 1

 7 4
 20 12 20 10 23 17 10


 예시 출력 1

 3 4 4 3

 */
public class 매출액의종류 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        solution(k, arr).stream().forEach(m -> System.out.print(m + " "));
    }


    public static List<Integer> solution(int k, int[] arr) {


        List<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // 묶는 단위의 전전 까지 미리 생성한다.
        // k 가 4일 경우 3개를 묶은걸 미리 생성한다.
        // 따라서 i 가 0부터이므로 0,1,2 인덱스 아이템
        for (int i = 0; i < k - 1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        //윈도우슬라이드 형식은
        //공용자본을 뒤에꺼 추가하고 앞에꺼 없애는 형태로 하나씩 밀고나가며 체크하는 형태이다.
        // like Queue
        int lt = 0;
        for (int rt = k - 1; rt < arr.length; rt++) {
            // 뒤에 한개 추가
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            answer.add(map.size());
            // 앞에 한개 빼기
            map.put(arr[lt], map.get(arr[lt]) - 1);
            if (map.get(arr[lt]) == 0) {
                map.remove(arr[lt]);
            }
            lt++;
        }

        return answer;
    }
}

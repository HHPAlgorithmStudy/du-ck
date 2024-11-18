package com.codingtest.codingtest.inflearn.chapter4_해쉬_정렬지원set;



import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 모든 아나그램 찾기
 설명

 S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.

 아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.


 입력
 첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.

 S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.


 출력
 S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.


 예시 입력 1

 bacaAacba
 abc
 예시 출력 1

 3

 */
public class 모든아나그램찾기__ {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input1 = in.next();
        String input2 = in.next();

        System.out.println(solution(input1, input2));
    }


    public static int solution(String input, String findItem) {
        int answer = 0;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        int length = findItem.length();

        // findItem 의 length - 1 만큼 미리 묶는다.
        for (int i = 0; i < length - 1; i++) {
            map.put(input.charAt(i), map.getOrDefault(input.charAt(i), 0) + 1);
        }

        int lt = 0;
        int rt = length - 1;
        while (rt < input.length()) {
            // map 에 추가 후 아나고램 체크
            map.put(input.charAt(rt), map.getOrDefault(input.charAt(rt), 0) + 1);   //
            if (isAnagram(map, findItem)) {
                answer++;
            }
            // 앞에꺼 -1 하고 0이된다면 remove
            map.put(input.charAt(lt), map.get(input.charAt(lt)) - 1);
            if (map.get(input.charAt(lt)) == 0) {
                map.remove(input.charAt(lt));
            }
            lt++;
            rt++;
        }
        return answer;
    }

    public static boolean isAnagram(LinkedHashMap<Character, Integer> map, String findItem) {
        LinkedHashMap<Character, Integer> tempMap = new LinkedHashMap<>(map);
        for (char item : findItem.toCharArray()) {
            if (!tempMap.containsKey(item)) {
                return false;
            }
            tempMap.put(item, tempMap.get(item) - 1);
            if (tempMap.get(item) == 0) {
                tempMap.remove(item);
            }
        }
        return true;
    }
}

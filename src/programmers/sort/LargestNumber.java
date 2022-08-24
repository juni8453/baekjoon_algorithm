package programmers.sort;

import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
        int[] numbers2 = {3, 30, 34, 5, 9};
        int[] numbers3 = {1, 1, 1};
        int[] numbers4 = {0, 0, 0};
        int[] numbers5 = {0, 1, 0};

        System.out.println(new Solution2().solution(numbers));
        System.out.println(new Solution2().solution(numbers2));
        System.out.println(new Solution2().solution(numbers3));
        System.out.println(new Solution2().solution(numbers4));
        System.out.println(new Solution2().solution(numbers5));
    }
}

class Solution2 {
    public String solution(int[] numbers) {
        StringBuffer answer = new StringBuffer();
        String[] strings = new String[numbers.length];

        // 정수형 배열 -> 문자열 배열
        for (int i = 0; i < strings.length; i++) {
            strings[i] = String.valueOf(numbers[i]);
        }

        // 문자열 내림차순 정렬
        Arrays.sort(strings, (o1, o2) ->
            (o2 + o1).compareTo(o1 + o2)
        );

        // 모든 문자열 숫자가 0인 경우
        // 하나라도 0 이 아니였다면 정렬 후 첫 번째 인덱스가 0일 수가 없어서 이렇게 처리
        if (strings[0].equals("0")) {
            return "0";
        }

        for (String str : strings) {
            answer.append(str);
        }

        return answer.toString();
    }
}

// numbers 배열의 순서를 재배치해 만들 수 있는 가장 큰 수를 문자열로 바꿔 return 하는 프로그램을 작성하라.
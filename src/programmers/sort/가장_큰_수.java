package programmers.sort;

import java.util.Arrays;

public class 가장_큰_수 {
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

        // 오름차순 공식을 쓰되 매개변수 순서를 바꿔 내림차순으로 변경한다.
        Arrays.sort(strings, (o2, o1) -> {
            if (o1.charAt(0) > o2.charAt(0)) return 1;
            else if (o1.charAt(0) < o2.charAt(0)) return -1;
            else {
                // 맨 앞자리 수가 같은 수를 비교해서 넣어줘야 한다. 3 , 30-> 330 이 나오도록
                return (o1 + o2).compareTo(o2 + o1);
            }
        });

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
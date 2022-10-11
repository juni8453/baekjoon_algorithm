package programmers.level2;

public class N진수_게임 {
    public static void main(String[] args) {
        int n = 2;
        int t = 4;
        int m = 2;
        int p = 1;

        int n2 = 16;
        int t2 = 16;
        int m2 = 2;
        int p2 = 1;

        System.out.println(new Solution().solution(n, t, m, p)); // result = "0111"
        System.out.println(new Solution().solution(n2, t2, m2, p2)); // result = "0111"
    }
}

class Solution {
    // 진법 n, 미리 구해야하는 숫자의 갯수 4, 참가인원 3, 나의 순서 p
    // 2, 8, 16 진법 사용
    public String solution(int n, int t, int m, int p) {
        StringBuilder convertedNum = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        // 내 순서가 1이고 참여인원이 3명이면서, 미리 구해야하는 숫자의 갯수가 4개라면
        // len = 참기인원 * 미리 구해야하는 숫자의 갯수 = 8

        int length = m * t;
        int count = 0; // 0 시작
        while (convertedNum.length() < length) {
            convertedNum.append(Integer.toString(count++, n)); // Integer.toString(count 를 2진수로 바꾼다.);
        } // 0 1 1 0 1 1 1 0 0

        // 자기 순서부터 m 건너뛰면서 저장
        for (int i = p - 1; i < length; i = i + m) {
            answer.append(convertedNum.charAt(i));
        }

        // 확인하니 소문자로 출력되기에 대문자로 변환
        return answer.toString().toUpperCase();
    }
}

// 말해야하는 숫자 t개를 공백없이 차례대로 문자열로 출력한다.
// 단, 10 ~ 15는 각각 대문자 A ~ F 로 출력한다.

// 2진법으로 게임하고, 4를 말해야하며, 2명이 참가하고 내 순서는 1번이다.
// -> 0,1,1,1 !

// 내 순서 p는 참가인원 m보다 항상 작거나 같다.
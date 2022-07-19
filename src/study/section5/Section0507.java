package study.section5;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Section0507 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputA = br.readLine();
        String inputB = br.readLine();

        String answer = solution(inputA, inputB);
        System.out.println(answer);
    }

    // need - C B A
    // plan - C B E A F G
    private static String solution(String needSubject, String myPlan) {
        String answer = "YES";
        Queue<Character> queue = new LinkedList<>();

        if (needSubject.length() > myPlan.length()) {
            return "NO";
        }

        for (char x : needSubject.toCharArray()) {
            queue.offer(x);
        }

        // 필수과목을 Queue 에 넣고 수업설계를 하나씩 비교해서 Queue Size 를 줄여줌
        for (char x : myPlan.toCharArray()) {
            if (queue.contains(x)) {

                // 이 경우는 순서가 맞지 않으므로 NO
                if (queue.poll() != x) {
                    answer = "NO";
                }
            }
        }

        if (!needSubject.isEmpty()) {
            answer = "NO";
        }

        return answer;
    }
}

/*
 * 총과목 - A, B, C, D, E, F, G / 필수과목 - C, B, A -> 꼭 이 순서대로 수업계획을 짜야한다.
 * 순서란, C를 먼저들어야 B를 들을 수 있고 C, B를 들어야 A를 들을 수 있는 것.
 * 현수가 짠 수업설계가 잘 되었다면 YES, 잘못된 설계면 NO 를 출력해라.
 * */

/*
    C, B, A 의 순서가 맞다면 D, E, F, G 와 같은 선택과목은 중간에 끼워지든 말던 상관이 없다.
 */
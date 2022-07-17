package study.section5;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Section0502Review {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputLine = br.readLine();
        String answer = solution(inputLine);

        System.out.println(answer);
    }

    private static String solution(String inputLine) {
        StringBuffer answer = new StringBuffer();
        Stack<Character> stack = new Stack<>();

        for (char x : inputLine.toCharArray()) {
            // 닫힌 괄호를 제외한 값 모든 stack 에 삽입
            if (x != ')') {
                stack.push(x);

            // 닫힌 괄호라면 열린괄호까지 전부 pop()
            } else {
                while (stack.pop() != '(');
            }
        }

        for (int i = 0; i < stack.size(); i++) {
            answer.append(stack.get(i));
        }

        return answer.toString();
    }
}

// 입력뙨 문자열에서 () 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력해라.
// input - (A(BC)D) EF (G(H)(IJ)K) LM (N)

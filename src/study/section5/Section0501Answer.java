package study.section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Section0501Answer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        String answer = solution(line);
    }

    private static String solution(String line) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();

        for (char x : line.toCharArray()) {
            if (x == '(') {
                stack.push(x);
            } else {
                // 닫는 괄호인데 스택이 비어있는지 ?
                if (stack.isEmpty()) {
                    return "NO";
                }

                // 닫는 괄호인데 스택이 비어있지 않다면 ?
                stack.pop();
            }
        }

        // 여는 괄호가 더 많은 경우
        if (!stack.isEmpty()) {
            return "NO";
        }

        return answer;
    }
}

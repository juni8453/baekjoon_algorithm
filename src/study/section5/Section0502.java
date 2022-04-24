package study.section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Section0502 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        String answer = solution(line);
        System.out.println(answer);
    }

    private static String solution(String line) {
        Stack<Character> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();

        for (char x : line.toCharArray()) {
            if (x != ')') {
                stack.push(x);
            }

            // 닫는 괄호를 만났다면 그 이전에 여는 괄호까지 pop
            else {
                while (stack.pop() != '(');
            }
        }

        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
        }

        return sb.toString();
    }
}

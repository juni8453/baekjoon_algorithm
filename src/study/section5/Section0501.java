package study.section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Section0501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        String answer = solution(line);
        System.out.println(answer);
    }

    private static String solution(String line) {
        String[] split = line.split("");
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("(")) {
                stack.push(split[i]);
            }

            if (stack.size() != 0) {
                if (split[i].equals(")")) {
                    stack.pop();
                }
            } else {
                return "NO";
            }
        }

        if (stack.size() != 0) {
            return "NO";
        }

        return "YES";
    }
}

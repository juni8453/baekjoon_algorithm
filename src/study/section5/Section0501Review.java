package study.section5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Section0501Review {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // ( ( ) ( ( ) ) ) ( ( ) 입력
        String line = br.readLine();
        String answer = solution(line);
        System.out.println(answer);
    }

    private static String solution(String line) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();

        // 맨 처음 괄호가 열린 괄호가 아니라면 바로 return "NO"
        char[] lineToCharArray = line.toCharArray();
        if (lineToCharArray[0] == ')') {
            return answer = "NO";
        }

        // 예) ( ( ) ( ( ) ) ) ( ( )  -> ( (
        for (Character x : line.toCharArray()) {
            if (x == '(') {
                stack.push(x);

            // 닫힌 괄호를 만나면, stack 의 맨 위 열린 괄호를 pop() 해준다.
            // pop() 하기 전에, stack 길이를 확인해야 한다.
            // 모든 탐색이 끝나고 stack 길이를 확인해 size == 0 이라면 YES, 아니라면 괄호가 남아있는 경우니 NO 를 반환한다.
            } else {
                if (stack.size() != 0) {
                    stack.pop();
                } else {
                    return "NO";
                }
            }
        }

        // 올바른 조건이 아닌 괄호 분기문을 모두 통과하면 해당 괄호는 올바른 괄호이므로, 그대로 YES 반환
        return answer;
    }
}

// 올바른 괄호일 시 YES, 올바르지 않으면 NO 출력
// 올바른 괄호 - ( ( ) ) ( )
// 올바르지 못한 괄호 - ( ( ) ( ) ) ), ( ( ) ( ( ) ) ) ( ( )
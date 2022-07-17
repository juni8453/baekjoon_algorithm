package study.section5;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Section0505 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int answer = solution(input);
        System.out.println(answer);
    }

    private static int solution(String input) {
        int count = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push(input.charAt(i));
            } else {
                // 레이저라면 ?
                if (input.charAt(i - 1) == '(') {
                    stack.pop();
                    count += stack.size();
                // 쇠 막대기라면 ?
                } else {
                    stack.pop();
                    count ++;
                }
            }
        }

        return count;
    }
}

/* 쇠막대기 문제
 * Input - ( ) ( ( ( ( ) ( ) ) ( ( ) ) ( ) ) ) ( ( ) ) / Output - 17
* 1. 쇠막대를 아래에서 위로 곂쳐놓는데, 자신보다 긴 쇠막대 위에만 곂쳐질 수 있다. 다만 끝 점은 곂치지 않는다.
* 2. 각 쇠막대를 자르는 레이저는 적어도 하나 존재한다.
* 3. 각 쇠막대를 자르는 레이저는 어떤 쇠막대의 양 끝점과도 곂치지 않는다.
*
* 레이저는 쌍 괄호로 표현할 수 있다.
* '(' 는 쇠막대의 왼쪽 끝, ')' 는 쇠막대의 오른쪽 끝이다.
* 쇠막대기와 레이저의 배치를 나타내는 Input 이 주여졌을 때, 잘려진 쇠막대기 조각의 총 개수를 구하여라.
*
* 즉, 쌍괄호가 바로 붙어서 나오면 레이저 (), 붙어 있지 않다면 쇠막대기 ( ~ )
*
 */

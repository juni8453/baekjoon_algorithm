package programmers.skill_check.level2;

import java.util.Stack;

public class 올바른_괄호 {
    public static void main(String[] args) {
        String s1 = "()()";
        String s2 = "(())()";
        String s3 = ")()(";
        String s4 = "(()(";

        System.out.println(new Solution1().solution(s1));
        System.out.println(new Solution1().solution(s2));
        System.out.println(new Solution1().solution(s3));
        System.out.println(new Solution1().solution(s4));
    }
}

class Solution1 {
    boolean solution(String s) {
        // Stack 을 사용해 풀이 (무조건 첫 괄호는 열린 괄호가 들어가야 괄호 간 짝이 성립한다)
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') { // 열린 괄호일 떄 스택에 삽입
                stack.push(s.substring(i, i + 1));

            } else { // 닫힌 괄호일 때,
                if (stack.isEmpty()) { // 첫 괄호가 닫힌 괄호라면 더 이상 확인할 필요가 없다.
                    return false;

                } else { // 닫힌 괄호가 첫 괄호가 아니라면
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty()) {
            return true;

        } else {
            return false;
        }
    }
}

// 괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 예를 들어
//
// "()()" 또는 "(())()" 는 올바른 괄호입니다.
// ")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.
// '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.
//
// 제한사항
// 문자열 s의 길이 : 100,000 이하의 자연수
// 문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.

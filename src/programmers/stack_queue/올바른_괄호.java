package programmers.stack_queue;

import java.util.Stack;

public class 올바른_괄호 {
    public static void main(String[] args) {
        String s1 = "))))";

        System.out.println(new Solution1().solution(s1));
    }
}

class Solution1 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        // 열린 괄호일 때 stack 에 넣어준다.
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(') {
//                stack.push(s.charAt(i));
//
//            } else if (s.charAt(i) == ')' && !stack.isEmpty()) { // 닫힌 괄호가 첫 괄호가 아니고,
//                if (stack.peek() == '(') { // 스택에서 꺼낸 값이 열린 괄호라면 스택을 비워준다.
//                    stack.pop();
//                }
//
//            } else {
//                stack.push(')');
//            }
//        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));

            } else {
                if (stack.isEmpty()) { // 첫 괄호가 닫힌 괄호라면 뒤를 확인할 필요도 없다.
                    return false;

                } else {
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
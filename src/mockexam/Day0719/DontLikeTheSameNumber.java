package mockexam.stak0719;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class DontLikeTheSameNumber {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int[] answer = solution(arr);

        Arrays.stream(answer).forEach(s -> System.out.println(s + " "));
    }

    private static int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        // 맨 처음 숫자는 pop() 되지 않도록 잡아줘야한다.
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);

            if (i != 0 && arr[i -1] == arr[i]) {
                stack.pop();
            }
        }

        int[] answer = new int[stack.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = stack.get(i);
        }
        return answer;
    }
}

// arr = { 0 ~ 9 }
// 0부터 9까지의 숫자가 arr 에 무작위로 들어가는데, 연속되는 숫자는 하나만 남기고 제거해야 한다.
// Input = [1,1,3,3,0,1,1] -> Output = [1,3,0,1]
// Input = [4,4,4,3,3] -> Output = [4,3]
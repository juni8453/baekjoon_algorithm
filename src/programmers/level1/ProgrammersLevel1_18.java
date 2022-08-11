package level1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ProgrammersLevel1_18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        String answer = solution(input);
        System.out.println(answer);
    }

    private static String solution(String input) {
        String answer = "";
        String[] inputArr = input.split("");

        Arrays.sort(inputArr, Comparator.reverseOrder());

        for (int i = 0; i < inputArr.length; i++) {
            answer += inputArr[i];
        }

        return answer;
    }
}

// input 은 영문 대소문자로만 이루어져있다.
// 대문자는 소문자보다 작은 것으로 간주한다.
// A (65) ~ Z (90) - a (97) ~ z (122) [아스키코드]

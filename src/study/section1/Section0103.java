package study.section1;

import java.util.Scanner;

public class Section0103 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String answer = solution(input);
        System.out.println(answer);
    }

    private static String solution(String input) {
        String answer = "";
        int high = 0;

        String[] split = input.split(" ");

        for (String s : split) {
            for (int k = 0; k < s.length(); k++) {
                if (s.length() > high) {
                    high = s.length();
                    // 2중 for 문에서는 끝나고 첫번째 for 문으로 돌아가기 위해 break;
                    break;
                }
            }
        }

        for (String s : split) {
            if (s.length() == high) {
                answer = s;
                // 같은 길이가 있는 경우 가장 앞쪽에 위치한 단어를 답으로 하기 때문에 break;
                break;
            }
        }

        return answer;
    }
}

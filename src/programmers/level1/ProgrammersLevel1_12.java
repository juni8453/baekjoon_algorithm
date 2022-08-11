package programmers.level1;

import java.util.Scanner;

public class ProgrammersLevel1_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String answer = solution(input);
        System.out.println(answer);
    }

    private static String solution(String input) {
        String answer = "";
        // split limit -1은 공백도 모두 포함해서 배열에 집어넣겠다는 의미이다.
        String[] words = input.split(" ", -1);
        char wordOfCh = ' ';
        int index = 0;

        for (int i = 0; i < words.length; i++) {
            for (int k = 0; k < words[i].length(); k++) {
                wordOfCh = words[i].charAt(k);

                // 단어의 인덱스가 짝수일 때,
                if (k % 2 == 0) {
                    answer += Character.toUpperCase(wordOfCh);
                }

                // 단어의 인덱스가 홀수일 때,
                if (k % 2 != 0) {
                    answer += Character.toLowerCase(wordOfCh);
                }
            }
            index += 1;

            if (index < words.length) {
                answer += " ";
            }
        }

        return answer;
    }
}

// 각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성
// 각 단어의 인덱스에 따라 짝수 번째인지, 홀수 번째인지 판단한다.
// "try hello world" ->	"TrY HeLlO WoRlD"




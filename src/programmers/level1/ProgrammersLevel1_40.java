package programmers.level1;

import java.util.Scanner;

public class ProgrammersLevel1_40 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        int answer = ProgrammersLevel1_40.solution(s);
        System.out.println(answer);
    }

    private static int solution(String s) {
        String[] strArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < strArr.length; i++) {
            if (s.contains(strArr[i])) {
                s = s.replace(strArr[i], Integer.toString(i));
            }
        }
        return Integer.parseInt(s);
    }
}

// 네오가 프로도에게 숫자를 건넬 때, 일부 자릿수를 영단어로 바꾼 카드를 건넨다.
// 프로도는 일부가 바뀐 문자열을 원래의 숫자로 바꾼 문자열로 찾아내야 한다.
// 문자열에서 영어로 바뀐 부분이 없다면 그대로 return

/* 입, 출력
*  s : "one4seveneight"   -> result : 1478
*  s : "23four5six7"      -> result : 234567
*  s : "2three45sixseven" -> result : 234567
*  s : "123"              -> result : 123
* */

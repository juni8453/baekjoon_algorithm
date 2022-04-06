package study.section1;

import java.util.Scanner;

public class Section0101Answer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        char b = sc.next().charAt(0);

        int answer = Section0101Answer.solution(a, b);
        System.out.println(answer);
    }

    private static int solution(String a, char b) {
        int answer = 0;

        a = a.toUpperCase();
        b = Character.toUpperCase(b);

//        for (int i = 0; i < a.length(); i++) {
//            if (a.charAt(i) == b) {
//                answer++;
//            }
//        }

        // 향상된 for 문으로 풀기 (뒤에는 배열,컬렉션이 올 수 있으므로 배열로 바꾸고 진행)
        // a.toCharArray() 은 char[] 이지 String[] 은 아니다 !
        for (char x : a.toCharArray()) {
            if (x == b) {
                answer++;
            }
        }

        return answer;
    }
}

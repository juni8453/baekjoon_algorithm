package study.section1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Section0104Answer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] str = new String[n];

        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
        }

        List<String> answer = solution(n, str);

        answer.forEach(System.out::println);
    }

    private static List<String> solution(int n, String[] str) {
        List<String> answer = new ArrayList<>();

//        전체 뒤집기
//        for (String x : str) {
//            String tmp = new StringBuffer(x).reverse().toString();
//            answer.add(tmp);
//        }

//      특정 문자만 뒤집기
        for (String x : str) {
            // String 은 변경할 수 없기 때문에 char 배열로 바꿔준다.
            // 맨 앞 인덱스는 lt, 맨 끝 인덱스는 rt -> lt ++ 와 rt -- 반복 -> 문자열 내부 끝과 끝을 계속 교환해줌
            char[] chars = x.toCharArray();
            int lt = 0;
            int rt = chars.length - 1;

            while (lt < rt) {
                char tmp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = tmp;
                lt ++;
                rt --;
            }

            // char 배열을 String 으로 변환
            String tmp = String.valueOf(chars);
            answer.add(tmp);
        }

        return answer;
    }
}

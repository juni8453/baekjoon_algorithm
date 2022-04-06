package study.section1;

import java.util.*;

public class Section0104 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        String[] strings = new String[count];

        for (int i = 0; i < strings.length; i++) {
            strings[i] = sc.next();
        }

        String[] answer = solution(strings);
        Arrays.stream(answer)
                .forEach(str -> System.out.println(str));
    }

    private static String[] solution(String[] strings) { // strings = {good, Time, Big}
        String[] answer = new String[strings.length];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = new StringBuffer(strings[i]).reverse().toString();
        }

        return answer;
    }
}

// 단어 뒤집기
// N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집에서 출력한다.
/*
* 3
* good -> doog
* Time -> emiT
* Big  -> giB
* */
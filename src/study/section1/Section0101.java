package study.section1;

import java.util.Scanner;

public class Section0101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();
        int count = 0;

        a = a.toLowerCase();
        b = b.toLowerCase();

        String[] split = a.split("");

        for (int i = 0; i < split.length; i++) {
            if (split[i].contains(b)) {
                count += 1;
            }
        }

        System.out.println(count);
    }
}

// 한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개가 존재하는지 알아내는 프로그램을 작성해라.
// 대,소문자를 구분하지 않고 문자열의 길이는 100을 넘지 않는다.
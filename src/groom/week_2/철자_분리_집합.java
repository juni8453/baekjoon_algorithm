package groom.week_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 철자_분리_집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int strLength = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int answer = 1;

        // str 이 goorm 라고 가정
        for (int i = 0; i < str.length() - 1; i++) {
            char stand = str.charAt(i);
            char compare = str.charAt(i + 1);

            if (compare == stand) {
                continue;

            } else {
                answer++;
            }
        }

        System.out.println(answer);
    }
}

// 문자열을 받아 같은 문자끼리 하나의 집합을 만들고 그 집합의 갯수를 출력해라.
// 단, 같은 문자라도 떨어져 있다면 다른 집합이라고 한다.




//    static int count;

//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        count = 0;
//        int n = Integer.parseInt(br.readLine());
//        String s = br.readLine();
//
//        boolean[] check = new boolean[26];
//        int prev = 0;
//
//        for (int i = 0; i < s.length(); i++) {
//            int now = s.charAt(i);
//
//            // 앞선 문자와 i 번째 문자가 같지 않다면 ?
//            if (prev != now) {
//                count++;
//                if (!check[now - 'a']) {
//                    check[now - 'a'] = true;
//                    prev = now;
//
//                } else {
//                    break;
//                }
//
//            } else {
//                continue;
//            }
//        }
//
//        System.out.println(count);
//    }
//}

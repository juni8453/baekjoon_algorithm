package baekjoonbronze.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1924 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int sumDay = 0;

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        // 1월 이면 굳이 이전 월의 날을 더할 필요가 없음
        for (int i = 1; i < x; i++) {
            sumDay += months[i];
        }
        // 이전 월의 날을 모두 더하고 입력된 일수만큼 또 더하기
        sumDay += y;

        switch(sumDay % 7) { //7의 나머지값을 이용해 분기처리
            case 0:
                System.out.println("SUN");
                break;
            case 1:
                System.out.println("MON");
                break;
            case 2:
                System.out.println("TUE");
                break;
            case 3:
                System.out.println("WED");
                break;
            case 4:
                System.out.println("THU");
                break;
            case 5:
                System.out.println("FRI");
                break;
            case 6:
                System.out.println("SAT");
                break;
        }
    }
}

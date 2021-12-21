package level1;

import java.util.Scanner;

public class ProgrammersLevel1_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        String answer = solution(a, b);
        System.out.println(answer);

    }

    public static String solution(int month, int day) {
        String answer = "";
        int[] monthOfDay = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int sumDay = 0;

        // 1월부터 시작해서 해당 월까지 모든 일수 더하기
        for (int i = 1; i < month; i++) {
            sumDay += monthOfDay[i];
        }

        // 입력받은 월의 이전 월 일수 모두 더하고 입력받은 일수도 더해주기
        sumDay += day;

        switch (sumDay % 7) {
            case 0 :
                answer = "THU";
                break;

            case 1 :
                answer = "FRI";
                break;

            case 2 :
                answer = "SAT";
                break;

            case 3 :
                answer = "SUN";
                break;

            case 4 :
                answer = "MON";
                break;

            case 5 :
                answer = "TUE";
                break;

            case 6 :
                answer = "WED";
                break;
        }

        return answer;
    }
}
// 월 1 ~ 12월 12개

// 2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요?
// 두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요.
// 요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT 입니다.
// 예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 "TUE"를 반환하세요.

// 제한 조건 2016년은 윤년입니다. (2월이 29일까지 있어서 366일)

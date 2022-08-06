package mockexam.Day0728;

import java.util.Scanner;

public class BiggestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        String answer = solution(numbers);
        System.out.println(answer);
    }

    private static String solution(int[] numbers) {
        StringBuffer answer = new StringBuffer();
        String[] ChangeNumberOfString = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            ChangeNumberOfString[i] = String.valueOf(numbers[i]).substring(0);
        }



        return answer.toString();
    }
}

/* [6, 10, 2] -> [6102, 6210, 1062, 1026, 2610, 2106] 을 만들 수 있다.
//
  이 중 가장 큰 숫자인 6210 을 문자열로 바꿔서 반환
  몇 자리 수이든 맨 앞자리 숫자가 큰 숫자가 맨 앞으로 와야한다.
   1. numbers 배열의 모든 원소를 int -> String
   2. 모든 숫자를 String 으로 변환
   3. 맨 앞자리 수만 다시 저장  // 같은 숫자가 있을 수 있으므로 안될 듯 ..
   4. 맨 앞자리 숫자가 가장 큰 수를 찾아서 일중 for 문으로 정렬 -> 큰 수가 맨 앞으로 오도록 퀵 정렬
   4. answer.append() 를 사용해 모든 문자형 숫자를 더해 반환

  TODO - [생각나는 반례]
   - 맨 앞자리 숫자가 같은 수가 1개 이상이라면 곂치는 숫자들은 서로의 뒷자리 숫자를 비교해야 한다.
* */

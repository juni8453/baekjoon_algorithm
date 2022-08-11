package level1;

import java.util.*;

public class ProgrammersLevel1_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();

        long answer = solution(n);
        System.out.println(answer);
    }

    private static long solution(long n) {
        long answer = 0;
        long copyN = n;
        int length = 0;

        // 배열의 길이는 n의 길이
        while (copyN != 0) {
            copyN /= 10;
            length += 1;
        }

        Long[] arr = new Long[length];
        long arrOfElement = 0;

        while (n != 0) {
            for (int i=0; i<arr.length; i++) {
                arrOfElement = n % 10;
                arr[i] = arrOfElement;
                n /= 10;
            }
        }
        Arrays.sort(arr, Collections.reverseOrder());

        String resultJoin = arrayJoin(arr);
        answer = Long.parseLong(resultJoin);

        return answer;

    }

    private static String arrayJoin(Long[] arr) {
        String resultJoin = "";

        for (int i = 0; i < arr.length; i++) {
            resultJoin += arr[i];
        }

        return resultJoin;
    }
}

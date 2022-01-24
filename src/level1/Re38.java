package level1;

import java.util.Arrays;
import java.util.Scanner;

public class Re38 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int participantNum = sc.nextInt();
        String[] participant = new String[participantNum];
        String[] completion = new String[participantNum - 1];

        for (int i = 0; i < participant.length; i++) {
            participant[i] = sc.next();
        }

        for (int i = 0; i < completion.length; i++) {
            completion[i] = sc.next();
        }

        String answer = Re38.solution(participant, completion);
        System.out.println(answer);
    }

    private static String solution(String[] participant, String[] completion) {
        String answer = "";
        int i = 0;

        // 각 배열 길이가 다르므로 탐색하기 전 정렬
        Arrays.sort(participant);
        Arrays.sort(completion);

        while (i < completion.length) {
            if (!participant[i].equals(completion[i])) {
                answer = participant[i];
                return answer;
            }
            i++;
        }

        return participant[i];
    }
}

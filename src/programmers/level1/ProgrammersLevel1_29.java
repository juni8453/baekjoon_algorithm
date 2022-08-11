package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProgrammersLevel1_29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }

        int[] answer = solution(numbers);

        Arrays.stream(answer)
                .forEach(s -> System.out.print(s + " "));
    }

    private static int[] solution(int[] numbers) {
        List<Integer> resultArr = new ArrayList<>();
        int result = 0;

        for (int i = 0; i < numbers.length; i++) {
            for (int k = i + 1; k < numbers.length; k++) {
                result = numbers[i] + numbers[k];

                // 중복 제거
                if (!resultArr.contains(result)) {
                    resultArr.add(result);
                }
            }
        }

        int[] answer = new int[resultArr.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = resultArr.get(i);
        }

        Arrays.sort(answer);

        return answer;
    }
}

// 정수 배열 numbers가 주어지는데, numbers 배열에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해
// 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 메소드를 구현해라.

// 완전탐색, List 사용 -> 오름차순 정렬 후 중복 제외하면 끝

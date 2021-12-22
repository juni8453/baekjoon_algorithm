package level1;

import java.util.*;

public class ProgrammersLevel1_21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] ints = new int[n];
        int divisor = sc.nextInt();

        for (int i = 0; i < n; i++) {
            ints[i] = sc.nextInt();
        }

        int[] answer = solution(ints, divisor);

        Arrays.stream(answer).forEach(s -> System.out.print(s + " "));
    }

    private static int[] solution(int[] ints, int divisor) {
        int[] answer = {};
        List<Integer> intList = new ArrayList<>();

        for (int i = 0; i < ints.length; i++) {
            if (ints[i] % divisor == 0) {
                intList.add(ints[i]);
            }
        }

        if(intList.isEmpty()) {
            intList.add(-1);
        }

        Collections.sort(intList);

        answer = new int[intList.size()];

        for (int i = 0; i < intList.size(); i++) {
            answer[i] = intList.get(i);
        }

        return answer;
    }
}

// return 하는 answer 는 오름차순으로 정리한 뒤 return
// divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 return

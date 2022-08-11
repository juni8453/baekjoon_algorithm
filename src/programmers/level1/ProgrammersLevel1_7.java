package level1;

import java.util.*;

public class ProgrammersLevel1_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }

        int[] answer = solution(arr1);

        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    private static int[] solution(int[] arr1) {
        int answer[] = {};
        List<Integer> arr2 = new ArrayList<>();

        if (arr1.length <= 1) {
            return new int[] {-1};
        }

        for (int i = 0; i < arr1.length; i++) {
            arr2.add(arr1[i]);
        }

        int min = Collections.min(arr2);
        int indexOfMin = arr2.indexOf(min);

        arr2.remove(indexOfMin);
        answer = new int[arr2.size()];

        for (int i = 0; i < arr2.size(); i++) {
            answer[i] = arr2.get(i);
        }

        return answer;
    }


}

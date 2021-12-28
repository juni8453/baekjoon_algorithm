package level1;

import java.util.Scanner;
import java.util.*;

public class ProgrammersLevel1_24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int[] answer = solution(arr);
        Arrays.stream(answer).forEach(s -> System.out.print(s + " "));
    }

    public static int[] solution(int[] arr) {
       List<Integer> tempList = new ArrayList<>();

       // 배열 arr의 값은 9를 넘는 수가 없으므로 10으로 비교해도 무방
       int prvNum = 10;

        for (int num : arr) {
            if (prvNum != num) {
                tempList.add(num);
                prvNum = num;
            }
        }

        int[] answer = new int[tempList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = tempList.get(i);
        }

        return answer;
    }
}

// arr = [1, 3, 4, 4, 5, 6, 6] 이면 [1, 3, 4, 5, 6] 을 return
// arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return
// arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return
// 즉, 배열 내에 인덱스가 붙어있는 숫자 중 같은 숫자 하나를 지우고 return 해줘야 한다.


// 다른 풀이

/*
package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Re_24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int[] answer = solution(arr);
        Arrays.stream(answer).forEach(s -> System.out.print(s + " "));
    }

    private static int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();

        // 받아온 배열의 0번째 인덱스를 넣어줘야함
        // 밑의 for문은 인덱스 0부터 시작하면 안되니까 인덱스 0을 처음에 따로 넣어줘야 하는 것
        list.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] != arr[i - 1])
                list.add(arr[i]);
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);

        return answer;
    }
}

*
*
* */

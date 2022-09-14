package programmers.brute_force;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {
    public static void main(String[] args) {
        String numbers1 = "17";
        String numbers2 = "011";

        System.out.println(new Solution2().solution(numbers1));
        System.out.println(new Solution2().solution(numbers2));
    }
}

class Solution2 {

    static Set<Integer> set = new HashSet<>();
    static char[] arr;
    static int[] checked;

    public int solution(String numbers) {
        arr = new char[numbers.length()];
        checked = new int[numbers.length()];

        for (int i = 0; i < numbers.length(); i++) {
            arr[i] = numbers.charAt(i);
        }

        DFS("", 0);

        return set.size();
    }

    // 순서에 상관이 있기 때문에 순열 공식으로 풀이해야 한다.
    // {1,2}, {2,1} 은 다른 것으로 취급하기 때문.
    private static void DFS(String str, int depth) {
        if (!str.equals("")) {
            int num = Integer.parseInt(str);
            if (isPrime(num)) {
                set.add(num);
            }
        }

        if (depth == arr.length) {
            return;

        } else {
            for (int i = 0; i < arr.length; i++) {
                if (checked[i] == 0) {
                    checked[i] = 1;
                    DFS(str + arr[i], depth + 1);
                    checked[i] = 0;
                }
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num == 0 || num == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}

/*
* "17" -> {7}, {17}, {71} return 3
* "011" -> {11}, {101} return 2
* 순서가 필요없는 nCm 조합공식으로 구해온 숫자들을 하나하나 소수인지 판별한다.
* */
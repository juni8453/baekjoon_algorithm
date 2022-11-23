package programmers.dfs;

public class 타겟넘버_Remind {
    public static void main(String[] args) {
        int[] numbers1 = {1, 1, 1, 1, 1};
        int target1 = 3;

        int[] numbers2 = {4, 1, 2, 1};
        int target2 = 4;

        System.out.println(new Solution6().solution(numbers1, target1));
        System.out.println(new Solution6().solution(numbers2, target2));
    }
}

class Solution6 {
    static int count;
    static int sTarget;
    static int[] sNumbers;

    public int solution(int[] numbers, int target) {
        sNumbers = numbers.clone();
        sTarget = target;

        dfs(0, 0);

        return count;
    }

    private static void dfs(int depth, int sum) {
        if (depth == sNumbers.length) {
            if (sum == sTarget) {
                count++;
            }

        } else {
            dfs(depth + 1, sum + sNumbers[depth]);
            dfs(depth + 1, sum - sNumbers[depth]);
        }
    }
}

// 주어진 정수배열을 가지고 적절히 더하거나 빼서 target 을 만들어야 한다.
package programmers.dfs;

public class 타겟넘버 {
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        System.out.println(new Solution1().solution(numbers, target));
    }
}

class Solution1 {

    static int nodeIdx;
    static int count;
    static int targetNumber;
    static int[] arr;

    public int solution(int[] numbers, int target) {
        nodeIdx = numbers.length;
        arr = new int[numbers.length];
        targetNumber = target;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = numbers[i];
        }

        DFS(0,0);

        return count;
    }

    private static void DFS(int depth, int sum) {
        if (nodeIdx == depth) {
            if (targetNumber == sum) {
                count++;
            }

        } else {
            DFS(depth + 1, sum + arr[depth]);
            DFS(depth + 1, sum - arr[depth]);
        }
    }
}

// 타겟넘버가 주어졌을 때, 숫자를 적절히 더하거나 빼서 타겟넘버를 만드는 경우의 수를 반환해라.

/*
* 1,1,1,1,1 로 숫자 3을 만들기 위해선 다섯 가지 방법이 있다.
*   -1+1+1+1+1 = 3
    +1-1+1+1+1 = 3
    +1+1-1+1+1 = 3
    +1+1+1-1+1 = 3
    +1+1+1+1-1 = 3
* */

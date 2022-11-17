package programmers.skill_check.level1;

public class 삼총사_찾기 {
    public static void main(String[] args) {
        int[] number = {-2, 3, 0, 2, -5};

        System.out.println(new Solution2().solution(number));
    }
}

class Solution2 {
    public int solution(int[] number) {
        int answer = 0;

        dfs(0);

        return answer;
    }

    private static void dfs(int depth) {
        if (depth == 2) {
            int sum = 0;

        } else {

        }
    }
}

// 3개의 정수를 더해 0이 되는 경우의 수를 찾아라.
//
package programmers.dfs;

import java.util.HashSet;
import java.util.Set;

public class network {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };

        int[][] computers2 = {
            {1, 1, 0},
            {1, 1, 1},
            {0, 1, 1}
        };

        System.out.println(new Solution().solution(n, computers));
        System.out.println(new Solution().solution(n, computers2));
    }
}

class Solution {
    static int[] unf;

    static int Find(int v) {
        if (v == unf[v]) {
            return unf[v];
        } else {
            return unf[v] = Find(unf[v]);
        }
    }

    static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;

        unf = new int[n];
        for (int i = 0; i < n; i++) {
            unf[i] = i;
        }

        // i,j = 1 이 아니고 0 인 이유는, unf 배열이 0 부터 시작하기 떄문에
        // computers 인접행렬이 인덱스 번호 2가 마지막이기 때문에 이렇게 맞춰줬다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j & computers[i][j] == 1) {
                    Union(i, j);
                }
            }
        }

        // Union - Find 자료구조를 사용해 unf[] 배열이 [1,1,2] 로 초기화 된 상태
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(Find(unf[i]));
        }

        return set.size();
    }
}

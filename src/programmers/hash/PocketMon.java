package programmers.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class PocketMon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(new Solution1().solution(nums));
    }
}

class Solution1 {
    public int solution(int[] nums) {
        int max = nums.length / 2;
        Set<Integer> set = new HashSet<>();

        // 중복을 제거하기 위해 HashSet 사용
        for (int num : nums) {
            set.add(num);
        }

        if (max > set.size()) {
            return set.size();
        } else {
            return max;
        }
    }
}

/*
* 3,1,2,3 -> 4마리 중 /2 인 최대 2마리만 데려갈 수 있다.
* 최대한 많은 종류의 포켓몬을 데려가려고 한다.
*
* */

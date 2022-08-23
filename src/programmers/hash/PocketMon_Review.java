package programmers.hash;

import java.util.HashSet;
import java.util.Set;

public class PocketMon_Review {
    public static void main(String[] args) {
        int[] nums1 = {3, 1, 2, 3};
        int[] nums2 = {3, 3, 3, 2, 2, 4};
        int[] nums3 = {3, 3, 3, 2, 2, 2};

        System.out.println(new Solution1_1().solution(nums1));
        System.out.println(new Solution1_1().solution(nums2));
        System.out.println(new Solution1_1().solution(nums3));
    }
}

class Solution1_1 {
    public int solution(int[] nums) {
        int answer = 0;
        int max = nums.length / 2;

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        // set.size 가 가져갈 수 있는 포켓몬 수인 max 보다 크다면
        if (set.size() > max) {
            return max;
        } else {
            answer = set.size();
            return answer;
        }
    }
}

// 최대 nums 배열의 /2 만큼 포켓몬을 가져갈 수 있다. -> nums.length = 4 라면, 최대 2마리까지 가능
// 같은 종류의 포켓몬은 중복해서 가져갈 수 없다.
// nums1 = 3마리, nums2 = 3마리, nums3 = 2마리의 return 값을 가진다.

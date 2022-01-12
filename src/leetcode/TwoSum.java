package leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class TwoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] answer = twoSum(nums, target);

        Arrays.stream(answer).forEach(s -> System.out.print(s + ","));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }

                else {
                    continue;
                }
            }
        }

        return answer;
    }
}

// nums = [2,7,11,15]
// target = 9
// Output = [0, 1]

// 배열을 탐색한다 -> 배열의 인덱스에서 두 개를 더했을 때 == target 이여야 한다.
// 여기서는 nums[0] + nums[1] == 9 이기 떄문에 Output [0, 1]

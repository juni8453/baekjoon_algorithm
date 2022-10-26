package groom.week_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소개팅 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 사람 수

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n]; // 각 사람의 점수
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 2 <= n <= 100_000 이기 때문에 Brute Force 불가
        // Two Pointer 로 풀이
        int leftPoint = 0;
        int rightPoint = 1;

        while (rightPoint != nums.length) {
            if (Math.abs(nums[leftPoint]) == Math.abs(nums[rightPoint])) {
                nums[leftPoint] = 200_001;
                nums[rightPoint] = 200_001;
                leftPoint++;
                rightPoint = leftPoint + 1;

            } else {
                rightPoint++;
            }
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 200_001) {
                sum += nums[i];
            }
        }

        System.out.println(sum);
    }
}

// n = 8, nums = [1,2,3,4,-1,-2,-3,-5]
// -> 4점, -5점이 서로 만나지 못했으므로 return -1
// n 은 항상 2의 배수 (짝으로 만나야기 떄문에)

